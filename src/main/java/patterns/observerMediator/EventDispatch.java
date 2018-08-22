package patterns.observerMediator;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class EventDispatch implements Observer {

    private final static EventDispatch dispatch = new EventDispatch();

    private Vector<EventCustomer> customer = new Vector<>();

    private EventDispatch(){

    }

    public static EventDispatch getDispatch(){
        return dispatch;
    }

    @Override
    public void update(Observable o, Object arg) {
        Product product = (Product)arg;
        ProductEvent event = (ProductEvent)o;
        for (EventCustomer e : customer) {
            for (EventCustomType customType : e.getCustomTypes()) {
                if(customType.getValue() == event.getType().getValue()){
                    e.exec(event);
                }
            }
        }
    }

    public void registerCustomer(EventCustomer customer){
        this.customer.add(customer);
    }
}
