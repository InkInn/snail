package patterns.observer;

public class Client {
    public static void main(String[] args) {
        HanFeiZI hanFeiZI = new HanFeiZI();
        LiSi liSi = new LiSi();
        hanFeiZI.addObserver(liSi);
        hanFeiZI.haveBreakfast();
    }
}
