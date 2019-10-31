package patterns.chain;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import patterns.chain.model.PushRequest;

import java.util.Map;
import java.util.Set;

/**
 * @author rcli
 * Created on 2019/8/24.
 */

@Slf4j
public class PushPipeline {

    private PushContext head;

    private PushContext tail;

    private static String HEAD_HANDLER_NAME = HeadHandler.class.getSimpleName();

    private static String TAIL_HANDLER_NAME = TailHandler.class.getSimpleName();

    // TODO 每个业务类型 不执行哪些操作
    private static Map<Integer, Set<String>> MSG_INVALID_HANDLER_CONFIG = Maps.newHashMap();

    static {
        MSG_INVALID_HANDLER_CONFIG.put(2,Sets.newHashSet("FirstHandler"));
    }

    // TODO 哪些handler 不执行
    private static Set<String> INVALID_HANDLER_CONFIG = Sets.newHashSet("SecondHandler");

    // TODO 哪些业务禁止推送
    private static Set<Integer> INVALID_MSG_CONFIG = Sets.newHashSet(1);

    public PushPipeline() {
        this.head = new PushContext(new HeadHandler(), this);
        this.tail = new PushContext(new TailHandler(), this);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public PushPipeline process(PushRequest pushRequest) {
        PushContext.invokePushActive(head, pushRequest);
        return this;
    }

    public PushPipeline close(PushRequest pushRequest) {
        PushContext.invokePushActive(tail, pushRequest);
        return this;
    }

    public boolean isActive(String handlerName, Integer msgType) {
        if (isHeadOrTail(handlerName)) {
            return true;
        } else {
            return isHandlerActive(handlerName) && isMsgActive(msgType) && isMsgHandlerActive(handlerName, msgType);
        }
    }


    public PushPipeline addLast(PushHandler pushHandler) {
        PushContext pushContext = new PushContext(pushHandler, this);
        addLast(pushContext);
        return this;
    }

    private void addLast(PushContext newCtx) {
        PushContext prev = tail.prev;
        newCtx.prev = prev;
        newCtx.next = tail;
        prev.next = newCtx;
        tail.prev = newCtx;
    }

    private boolean isMsgHandlerActive(String handlerName, Integer msgType) {
        Set<String> invalidHandler = MSG_INVALID_HANDLER_CONFIG.get(msgType);
        if (null == invalidHandler) return true;
        return !invalidHandler.contains(handlerName);
    }

    private boolean isMsgActive(Integer msgType) {
        return !INVALID_MSG_CONFIG.contains(msgType) && msgType != null;
    }

    private boolean isHandlerActive(String handlerName) {
        return !INVALID_HANDLER_CONFIG.contains(handlerName);
    }

    private boolean isHeadOrTail(String handlerName) {
        return HEAD_HANDLER_NAME.equalsIgnoreCase(handlerName) || TAIL_HANDLER_NAME.equalsIgnoreCase(handlerName);
    }

    static class HeadHandler implements PushHandler {

        @Override
        public void pushActive(PushContext ctx, PushRequest pushRequest) {
            log.info("Push Start");
            ctx.nextPushActive(pushRequest);
        }
    }

    static class TailHandler implements PushHandler {

        @Override
        public void pushActive(PushContext ctx, PushRequest pushRequest) {
            log.info("Push End {}", pushRequest.getValue());
        }
    }
}
