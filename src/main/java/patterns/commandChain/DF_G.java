package patterns.commandChain;

public class DF_G extends AbstractDF {
    @Override
    protected String getOperateParam() {
        return super.G_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return DiskManager.df_g();
    }
}
