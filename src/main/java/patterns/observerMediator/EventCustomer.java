package patterns.observerMediator;

import java.util.Vector;

public abstract class EventCustomer {

    private Vector<EventCustomType> customTypes = new Vector<>();

    public EventCustomer(EventCustomType type){
        addCustomType(type);
    }

    public void addCustomType(EventCustomType type){
        customTypes.add(type);
    }

    public Vector<EventCustomType> getCustomTypes() {
        return customTypes;
    }

    public abstract void exec(ProductEvent event);
}
