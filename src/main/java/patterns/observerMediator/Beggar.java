package patterns.observerMediator;

public class Beggar extends EventCustomer {

    public Beggar(){
        super(EventCustomType.DEL);
    }

    @Override
    public void exec(ProductEvent event) {
        Product p = event.getSource();
        ProductEventType type = event.getType();
        System.out.println("乞丐： " + p.getName() + " 销毁= " + type);
    }
}
