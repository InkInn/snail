package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future1 = test();
        System.out.println(Thread.currentThread().getName());
        System.out.println(future1.get());
    }

    public static Future<String> test() throws InterruptedException {
        return new Future<String>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public String get() throws InterruptedException, ExecutionException {
                System.out.println(Thread.currentThread().getName() + "test");
                Thread.sleep(1000);
                return "hahha";
            }

            @Override
            public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };
    }
}
