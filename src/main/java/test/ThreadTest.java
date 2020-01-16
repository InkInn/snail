package test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rcli
 * Created on 2019/12/27.
 */
public class ThreadTest {

    public static final List<Integer> pool = new LinkedList<>();
    public static final int MAX_COUNT = 100;

    class Product extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (pool) {
                    if (pool.size() == MAX_COUNT) {
                        try {
                            pool.wait();
                        } catch (Exception e) {
                            //
                        }
                    }
                    pool.add(1);
                    pool.notifyAll();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (pool) {
                    if (pool.size() < 1) {
                        try {
                            pool.wait();
                        } catch (Exception e) {
                            //
                        }
                    }
                    pool.remove(0);
                    pool.notifyAll();
                }
            }
        }
    }
}
