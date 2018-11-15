package rxJava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                System.out.println("Observable thread is :" + Thread.currentThread().getName());
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                observableEmitter.onNext(3);
                observableEmitter.onComplete();
                observableEmitter.onNext(4);
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            private Disposable mDisposable;
            private int i;
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("subscribe");
                mDisposable = disposable;
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Observer thread is :" + Thread.currentThread().getName());
                System.out.println(integer);
                i++;
                if(i == 2){
                    System.out.println("dispose");
                    mDisposable.dispose();
                    System.out.println("isDisposed: " + mDisposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        };

//        observable.subscribe(observer);
        observable.subscribeOn(Schedulers.newThread()).observeOn(Schedulers.trampoline()).subscribe(observer);
    }


    public static void test(){
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(1);
            }
        });

        Observable<Integer> observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(1);
            }
        });


        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
            }

            @Override
            public void onNext(Integer integer) {
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        };

    }
}
