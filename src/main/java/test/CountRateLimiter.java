package test;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rcli
 * Created on 2020/4/3.
 */
public class CountRateLimiter {

    private static final long TRY_LOCK_TIMEOUT = 200L;  // 200ms.

    private Stopwatch stopwatch;

    private AtomicInteger currentCount = new AtomicInteger(0);

    /* the max permitted access count per second */
    private final int limit;

    private Lock lock = new ReentrantLock();

    public CountRateLimiter(int limit) {
        this(limit, Stopwatch.createStarted());
    }

    protected CountRateLimiter(int limit, Stopwatch stopwatch) {
        this.limit = limit;
        this.stopwatch = stopwatch;
    }

    public boolean tryAcquire() throws Exception {
        int updatedCount = currentCount.incrementAndGet();
        if (updatedCount <= limit) {
            return true;
        }
        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                try {
                    if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
                        currentCount.set(0);
                        stopwatch.reset();
                    }
                    updatedCount = currentCount.incrementAndGet();
                    return updatedCount <= limit;
                } finally {
                    lock.unlock();
                }
            } else {
                throw new Exception("tryAcquire() wait lock too long:" + TRY_LOCK_TIMEOUT + "ms");
            }
        } catch (InterruptedException e) {
            throw new Exception("tryAcquire() is interrupted by lock-time-out.", e);
        }
    }
}
