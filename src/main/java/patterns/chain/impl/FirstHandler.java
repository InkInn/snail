package patterns.chain.impl;

import lombok.extern.slf4j.Slf4j;
import patterns.chain.PushContext;
import patterns.chain.PushHandler;
import patterns.chain.model.PushRequest;

/**
 * @author rcli
 * Created on 2019/8/25.
 */

@Slf4j
public class FirstHandler implements PushHandler {

    @Override
    public void pushActive(PushContext ctx, PushRequest pushRequest) {
        try {
            pushRequest.setValue(pushRequest.getValue() + " " + getClass().getSimpleName());
            log.info(pushRequest.getValue());
            ctx.nextPushActive(pushRequest);
        } catch (Exception e) {
            ctx.exceptionCaught(pushRequest, e, "FirstHandler error");
        }
    }
}
