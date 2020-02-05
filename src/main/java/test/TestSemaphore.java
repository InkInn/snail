package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author rcli
 * Created on 2020/1/19.
 */
public class TestSemaphore {

    public static void m(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        TestRunner runner1 = new TestRunner();
        TestRunner runner2 = new TestRunner();
    }

    static int count;
    //初始化信号量
    static final Semaphore s = new Semaphore(1);

    //用信号量保证互斥
    static void addOne() throws Exception {
        s.acquire();
        try {
            count += 1;
        } finally {
            s.release();
        }
    }


    static class TestRunner extends Thread {
        @Override
        public void run() {
            try {
                addOne();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
