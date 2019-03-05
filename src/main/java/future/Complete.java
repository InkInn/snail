package future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Complete {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        Random rand = new Random();
//        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000 + rand.nextInt(1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return 100;
//        });
//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000 + rand.nextInt(1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "abc";
//        });
//        CompletableFuture<Void> f = CompletableFuture.allOf(future1, future2);
//        CompletableFuture<Object> f =  CompletableFuture.anyOf(future1,future2);
//        System.out.println(f.get());
        CompletableFuture<Integer> future =  complete();
        future.complete(2);
        System.out.println(future.get(100,TimeUnit.MILLISECONDS));

//        System.out.println(complete().get(100, TimeUnit.MILLISECONDS));
    }

    public static void testRunAsync() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello");
        });
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("CompletableFuture");
    }


    public static void testSupplyAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("CompletableFuture");
    }

    public static CompletableFuture<Long> testSupplyAsyncApply() {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            if (true) {
                throw new RuntimeException();
            }
            return "1111";
        }).thenApplyAsync(result -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return Long.valueOf(result);
        }).exceptionally(e -> {
            System.out.println("1212");
            return 0L;
        });

        System.out.println("CompletableFuture");
        return future;
    }

    public static void testComplete() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        future.complete("World");

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testCompleteException() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        future.completeExceptionally(new Exception());
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testAllof() throws Exception {
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {/**/
                Thread.sleep(10000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        CompletableFuture<Void> f = CompletableFuture.allOf(future1, future2);
//        CompletableFuture<Object> f =  CompletableFuture.anyOf(future1,future2);

        CompletableFuture<Long> resultFuture = new CompletableFuture<>();

//        resultFuture = future1.thenCombineAsync(future2,(num, string) -> {
//      }).t
    }

    public static void testCompose() throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1);

        CompletableFuture<Long> future1 = CompletableFuture.supplyAsync(() -> 2L);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> " world");

        CompletableFuture<String> resultFuture = future.thenCombineAsync(future1, (r1, r2) -> {
            System.out.println(Thread.currentThread().getName());
            return r1 + r2;
        }).thenCombineAsync(future2, (r2, r3) -> {
            System.out.println(Thread.currentThread().getName());
            return r2 + r3;
        });

        try {
            System.out.println(resultFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Integer> testApply(String k) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(k + " " + "111" + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).thenApply(i -> {
            System.out.println(k + " " + "222" + " " + Thread.currentThread().getName());
            return String.valueOf(i);
        }).thenApply(i -> {
            System.out.println(k + " " + "333" + " " + Thread.currentThread().getName());
            return 1;
        }).exceptionally(e -> {
            return null;
        });
    }

    public static void testApply1(String k) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<String> f = future.thenApplyAsync(i -> i * 10).thenApply(i -> i.toString());

    }

    public static void testCompose(String k) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });

        CompletableFuture<String> f = future.thenCompose(i -> {

            return CompletableFuture.supplyAsync(() -> {

                return (i * 10) + "";

            });

        });
    }

    private static CompletableFuture<Integer> testGetOrJoin() {
        return CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });
    }

    private static CompletableFuture<Integer> complete(){
        return CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return 1;
        }).whenComplete((result, e) -> {
            System.out.println("complete" + result);
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return 0;
        });
    }

}
