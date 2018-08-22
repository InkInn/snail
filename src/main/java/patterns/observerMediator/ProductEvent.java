package patterns.observerMediator;

import java.util.Observable;

public class ProductEvent extends Observable {

    private Product source;

    private ProductEventType type;

    public ProductEvent(Product p){
        this(p,ProductEventType.NEW_PRODUCT);
    }

    public ProductEvent(Product product, ProductEventType type){
        this.source = product;
        this.type = type;
        notifyEventDispatch();
    }

    public Product getSource(){
        return source;
    }

    public ProductEventType getType(){
        return this.type;
    }

    private void notifyEventDispatch(){
        super.addObserver(EventDispatch.getDispatch());
        super.setChanged();
        super.notifyObservers(source);
    }
}
