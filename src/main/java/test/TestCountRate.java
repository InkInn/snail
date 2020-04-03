package test;

/**
 * @author rcli
 * Created on 2020/4/3.
 */
public class TestCountRate {

    public static void main(String[] args) throws Exception {
        testAcquire();
    }

    public static void testAcquire() throws Exception {
        CountRateLimiter limiter = new CountRateLimiter(1);
        for (int i = 1; i < 10; i = i + 1) {
            boolean waitTime = limiter.tryAcquire();
            System.out.println("curTime = " + System.currentTimeMillis() + " acq: " + i + " waitTime: " + waitTime);
            Thread.sleep(1100);
        }
    }
}
