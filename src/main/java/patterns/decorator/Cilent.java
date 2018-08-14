package patterns.decorator;

public class Cilent {

    public static void main(String[] args) {
        System.out.println("======很久很久以前的丑小鸭========");
        Swan duckling = new UglyDuckling();
        duckling.desAppaearance();
        duckling.cry();
        duckling.fly();

        System.out.println("\n=======小鸭终于发现自己是一只天鹅");
        duckling = new BeautifyAppearance(duckling);
        duckling = new StrongBehavior(duckling);

        duckling.desAppaearance();
        duckling.cry();
        duckling.fly();

    }
}
