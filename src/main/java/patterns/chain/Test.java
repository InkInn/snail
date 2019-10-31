package patterns.chain;

import lombok.extern.slf4j.Slf4j;
import patterns.chain.impl.FirstHandler;
import patterns.chain.impl.SecondHandler;
import patterns.chain.impl.ThirdHandler;
import patterns.chain.model.PushRequest;

import java.util.concurrent.CompletableFuture;

/**
 * @author rcli
 * Created on 2019/8/24.
 */
@Slf4j
public class Test {

    public static void main(String[] args) {


        PushPipeline pushPipeline = getSinglePipeline();
        PushRequest pushRequest = new PushRequest();
        pushRequest.setValue("request1");
        pushRequest.setMsgType(1);

        PushRequest pushRequest2 = new PushRequest();
        pushRequest2.setValue("request2");
        pushRequest2.setMsgType(2);


        PushRequest pushRequest3 = new PushRequest();
        pushRequest3.setValue("request3");
        pushRequest3.setMsgType(3);

        CompletableFuture.runAsync(() -> {
            log.info(Thread.currentThread().getName());
            pushPipeline.process(pushRequest);
        });
        CompletableFuture.runAsync(() -> {
            log.info(Thread.currentThread().getName());
            pushPipeline.process(pushRequest2);
        });
        CompletableFuture.runAsync(() -> {
            log.info(Thread.currentThread().getName());
            pushPipeline.process(pushRequest3);
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static PushPipeline getSinglePipeline() {
        FirstHandler firstHandler = new FirstHandler();
        SecondHandler secondHandler = new SecondHandler();
        ThirdHandler thirdHandler = new ThirdHandler();
        PushPipeline pushPipeline = new PushPipeline();
        pushPipeline.addLast(firstHandler).addLast(secondHandler).addLast(thirdHandler);
        return pushPipeline;
    }


}
