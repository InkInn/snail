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

    static class Product extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                synchronized (pool) {
                    if (pool.size() == MAX_COUNT) {
                        try {
                            pool.wait();
                        } catch (Exception e) {
                            //
                        }
                    }
                    pool.add(++i);
                    pool.notifyAll();
                }
            }
        }
    }

    static class Consumer extends Thread {
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
                    System.out.println(pool.get(0));
                    pool.remove(0);
                    pool.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Product product = new Product();
        Consumer consumer = new Consumer();
        product.start();
        consumer.start();
        Thread.sleep(10000000);
    }
}
