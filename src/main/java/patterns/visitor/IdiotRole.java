package patterns.visitor;

public class IdiotRole implements Role {

    public void accept(AbsActor actor) {
        actor.act(this);
    }
}
