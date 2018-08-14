package patterns.decorator;

public class BeautifyAppearance extends Decorator {

    public BeautifyAppearance(Swan swan) {
        super(swan);
    }

    @Override
    public void desAppaearance() {
        System.out.println("外表纯白色，非常惹人喜爱");
    }
}
