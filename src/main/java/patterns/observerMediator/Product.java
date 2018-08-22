package patterns.observerMediator;

public class Product implements Cloneable {

    private String name;

    private boolean canChanged = false;

    public Product(ProductManager manager, String name){
        if(manager.isCreateProduct()){
            canChanged = true;
            this.name = name;
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(canChanged) this.name = name;
    }

    @Override
    protected Product clone() {
        Product product = null;
        try{
            product = (Product) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return product;
    }
}
