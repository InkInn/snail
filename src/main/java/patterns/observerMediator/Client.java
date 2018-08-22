package patterns.observerMediator;

public class Client {
    public static void main(String[] args) {
        EventDispatch eventDispatch = EventDispatch.getDispatch();
        eventDispatch.registerCustomer(new Beggar());
        ProductManager factory = new ProductManager();

        Product product = factory.createProduct("原子弹");
        factory.abandonProduct(product);
    }
}
