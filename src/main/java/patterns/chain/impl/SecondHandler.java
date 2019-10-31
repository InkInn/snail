package patterns.chain.impl;

import lombok.extern.slf4j.Slf4j;
import patterns.chain.PushContext;
import patterns.chain.PushHandler;
import patterns.chain.model.PushRequest;

/**
 * @author rcli
 * Created on 2019/8/24.
 */
@Slf4j
public class SecondHandler implements PushHandler {

    @Override
    public void pushActive(PushContext ctx, PushRequest pushRequest) {
        try {
            pushRequest.setValue(pushRequest.getValue() + " " + getClass().getSimpleName());
            log.info(pushRequest.getValue());
            ctx.nextPushActive(pushRequest);
        } catch (Exception e) {
            ctx.exceptionCaught(pushRequest, e, "SecondHandler error");
        }
    }
}
