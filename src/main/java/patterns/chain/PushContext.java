package patterns.chain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import patterns.chain.model.PushRequest;

/**
 * @author rcli
 * Created on 2019/8/24.
 */
@Data
@Slf4j
public class PushContext {

    private PushHandler pushHandler;

    public String handlerClassName;

    private PushPipeline pushPipeline;

    public PushContext prev;

    public PushContext next;


    public PushContext(PushHandler pushHandler, PushPipeline pushPipeline) {
        this.pushHandler = pushHandler;
        this.pushPipeline = pushPipeline;
        this.handlerClassName = pushHandler.getClass().getSimpleName();
    }

    // 入口
    static void invokePushActive(PushContext context, PushRequest pushRequest) {
        context.invokePushActive(pushRequest);
    }


    public PushContext nextPushActive(PushRequest pushRequest) {
        invokePushActive(next, pushRequest);
        return this;
    }


    public PushContext exceptionCaught(PushRequest pushRequest, Throwable cause, String info) {
        log.error(info, cause);
        pushPipeline.close(pushRequest);
        return this;
    }


    // 执行
    private void invokePushActive(PushRequest pushRequest) {
        if (pushPipeline.isActive(handlerClassName, pushRequest.getMsgType())) {
            pushHandler.pushActive(this, pushRequest);
        } else {
            log.info("msg: {} skip handler: {}", pushRequest.getMsgType(), handlerClassName);
            nextPushActive(pushRequest);
        }
    }

}
