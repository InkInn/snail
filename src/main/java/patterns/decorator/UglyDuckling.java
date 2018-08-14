package patterns.decorator;

public class UglyDuckling implements Swan {

    @Override
    public void fly() {
        System.out.println("不能飞行");
    }

    @Override
    public void cry() {
        System.out.println("叫声是克鲁-----克鲁----克鲁");
    }

    @Override
    public void desAppaearance() {
        System.out.println("外形是脏兮兮的白色，毛茸茸的大脑袋");
    }
}
