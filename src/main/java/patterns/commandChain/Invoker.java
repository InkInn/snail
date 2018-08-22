package patterns.commandChain;

public class Invoker {
    public String exec(String commandStr){
        String result = "";
        CommandVO vo = new CommandVO(commandStr);
        if (CommandEnum.getNames().contains(vo.getCommandName())) {
            String className = CommandEnum.valueOf(vo.getCommandName()).getValue();
            Command command;
            try {
                command = (Command)Class.forName(className).newInstance();
                result = command.execute(vo);
            }catch (Exception e){
                result = "无法执行命令，请检查格式";
            }
        }
        return result;
    }
}
