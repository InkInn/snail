package patterns.command.chain;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author rcli
 * Created on 2019/9/1.
 */

@Slf4j
public class Commands3  implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        Object v1 = context.get("k1");
        log.info("do something by Commands3... params is {}", JSONObject.toJSONString(context));
        if(v1 != null){
            int IntV1 = (Integer) v1;
            context.put("k1", IntV1+1);
        }
        return false;
    }
}
