package rxJava;

import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) throws Exception{
        flow();
    }

    public static void flow(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for(int i = 0; ; i++){
                    emitter.onNext(i);
                }
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer % 10 == 0;
            }
        }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }

    public static void flowable(){
        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR);

        Subscriber<Integer> downStream = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        upstream.subscribe(downStream);
    }

    public static void interval(){
        Flowable.interval(1, TimeUnit.MILLISECONDS).subscribe(new Subscriber<Long>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
