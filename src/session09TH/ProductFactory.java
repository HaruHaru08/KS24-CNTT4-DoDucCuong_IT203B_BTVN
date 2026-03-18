package session09TH;

public class ProductFactory {
    public Product createProduct(Product product) {
        if(product instanceof PhysicalProduct){
            return new PhysicalProduct(product.getId(), product.getName(), product.getPrice(), ((PhysicalProduct) product).getWeight());
        }else if(product instanceof DigitalProduct){
            return new DigitalProduct(product.getId(), product.getName(), product.getPrice(), ((DigitalProduct) product).getSize());
        }else{
            return null;
        }
    }
}
