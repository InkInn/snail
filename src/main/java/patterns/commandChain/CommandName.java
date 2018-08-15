package patterns.commandChain;

public abstract class CommandName {
    private CommandName nextOperator;

    public final String handleMessage(CommandVO vo) {
        String result = "";
        if(vo.getParamList().size() == 0 || vo.getParamList().contains(this.getOperateParam())){
            result = this.echo(vo);
        }else {
            if (this.nextOperator != null){
                result = this.nextOperator.handleMessage(vo);
            }else {
                result = "命令无法执行";
            }
        }
        return result;
    }

    public void setNext(CommandName nextOperator){
        this.nextOperator = nextOperator;
    }


    protected abstract String getOperateParam();


    protected abstract String echo(CommandVO vo);
}
