package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

/**
 * @author rcli
 * Created on 2019/12/6.
 */
public class LimitTest {

    private static Jedis jedis;

    public static void main(String[] args) {
        setup();
        for (int i = 0; i < 20; i++) {
            System.out.println(isActionAllowed("12312", "1", 10, 10));
        }
    }

    public static void setup() {
        jedis = new Jedis("192.168.3.44", 6379);
        jedis.auth("jredis123456");
    }

    public static boolean isActionAllowed(String deviceId, String msgType, int periodSeconds, int maxCount) {
        String key = String.format("hist:%s:%s", deviceId, msgType);
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();
        pipe.multi();
        pipe.zadd(key, nowTs, String.valueOf(nowTs));
        pipe.zremrangeByScore(key, 0, nowTs - periodSeconds * 1000);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, periodSeconds + 1);
        pipe.exec();
        pipe.close();
        return count.get() <= maxCount;
    }
}
