package patterns.commandChain;

public class DF extends AbstractDF {

    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return DiskManager.df();
    }
}
