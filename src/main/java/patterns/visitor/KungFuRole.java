package patterns.visitor;

public class KungFuRole implements Role {

    public void accept(AbsActor actor) {
        actor.act(this);
    }
}
