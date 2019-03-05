package future;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class GuaTest {
    static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
    public static void main(String[] args) throws InterruptedException {
        test();
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }
        Thread.sleep(1000);
    }

    private static ListenableFuture<Integer> test() throws InterruptedException {
        ListenableFuture<Integer> submit = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(1 + " " + Thread.currentThread().getName());
                return 1;
            }
        });
        Futures.addCallback(submit, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(2 + " " + Thread.currentThread().getName());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        return submit;
    }
}
