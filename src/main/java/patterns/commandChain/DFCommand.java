package patterns.commandChain;

public class DFCommand extends Command {

    @Override
    public String execute(CommandVO vo) {
        return super.buildChain(AbstractDF.class).get(0).handleMessage(vo);
    }
}
