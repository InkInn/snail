package patterns.commandChain;

import org.apache.commons.lang3.ClassUtils;

import java.util.List;

public abstract class Command {
    public abstract String execute(CommandVO vo);

    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> abstractClass){
        List<Class> classes = ClassUtils.get
    }
}
