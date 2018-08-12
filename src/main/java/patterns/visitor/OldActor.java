package patterns.visitor;

public class OldActor extends AbsActor {
    @Override
    public void act(KungFuRole role) {
        System.out.println("年龄大了，不能演功夫角色");
    }
}
