package patterns.command.chain;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;

/**
 * @author rcli
 * Created on 2019/9/1.
 */
public class CommandTest {

    public static void main(String[] args) {
        ChainBase chain = new ChainBase();
        chain.addCommand(new Commands1());
        chain.addCommand(new Commands2());
        chain.addCommand(new Commands3());
        Context context = new ContextBase();
        context.put("k1",1);
        try {
            chain.execute(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
