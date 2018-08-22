package patterns.commandChain;


import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    public abstract String execute(CommandVO vo);

    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> abstractClass){
        List<Class> classes = ClassUtils.getSonClass(abstractClass);
        List<CommandName> commandNameList = new ArrayList<>();
        for (Class aClass : classes) {
            CommandName commandName = null;
            try {
                commandName = (CommandName)Class.forName(aClass.getName()).newInstance();
            }catch (Exception e){

            }
            if(commandNameList.size() > 0){
                commandNameList.get(commandNameList.size() - 1).setNext(commandName);
            }
            commandNameList.add(commandName);
        }
        return commandNameList;
    }
}
