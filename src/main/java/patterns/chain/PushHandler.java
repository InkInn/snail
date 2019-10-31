package patterns.chain;

import patterns.chain.model.PushRequest;

/**
 * @author rcli
 * Created on 2019/8/24.
 */
public interface PushHandler {

    void pushActive(PushContext ctx, PushRequest pushRequest);
}
