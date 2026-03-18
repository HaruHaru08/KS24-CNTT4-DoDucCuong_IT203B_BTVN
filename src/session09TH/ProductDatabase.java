package session09TH;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    List<Product> products=new ArrayList<>();
    public void addProduct(Product product){
        products.add(product);
    }
    public void displayProducts(){
        for (Product product : products) {
            System.out.println(product.dispayInfo());
        }
    }
    public void removeProduct(String id){
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                break;
            }
        }

    }

    public void updateProduct(String id, Product newProduct){
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                break;
            }
        }
    }
}
