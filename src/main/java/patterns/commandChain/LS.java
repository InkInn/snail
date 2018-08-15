package patterns.commandChain;

public class LS extends AbstractLS {

    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return null;
    }
}
