package patterns.observer;

import java.util.Observable;

public class HanFeiZI extends Observable implements IHanFeizi {

    @Override
    public void haveBreakfast() {
        System.out.println("hanfeizi: have breakfast");
        super.setChanged();
        super.notifyObservers("having breakfirst");
    }

}
