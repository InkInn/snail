package spring.springInAction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rcli
 * Created on 2019-06-02.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {

    private RedisTemplate<String, String> redisTemplate;

    @Before
    public void setup() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("192.168.3.44", 6379);
        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();
        builder.connectTimeout(Duration.ofSeconds(30));
//        config.setPassword("jredis123456");

        RedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(config, builder.build());
        RedisTemplate<String, String> redis = new RedisTemplate<>();
        redis.setConnectionFactory(redisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redis.setKeySerializer(stringRedisSerializer);
        redis.setValueSerializer(stringRedisSerializer);
        redis.setHashKeySerializer(stringRedisSerializer);
        redis.setHashValueSerializer(stringRedisSerializer);
        redis.afterPropertiesSet();
        redisTemplate = redis;
    }

    @Test
    public void testRedisObj() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("123", "hello");

        redisTemplate.opsForHash().putAll("hash", properties);

        Map<Object, Object> ans = redisTemplate.opsForHash().entries("hash");
        System.out.println("ans: " + ans);
    }

}
