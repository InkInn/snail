package patterns.commandChain;

public class DF_K extends AbstractDF {

    @Override
    protected String getOperateParam() {
        return super.K_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return DiskManager.df_k();
    }
}
