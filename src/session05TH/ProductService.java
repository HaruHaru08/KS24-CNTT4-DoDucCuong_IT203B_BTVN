package session05TH;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) throws InvalidProductException{
        boolean exists = products.stream().anyMatch(p -> p.getId()==product.getId());
        if(exists){
            throw new InvalidProductException("Id đã tồn tại");
        }
        products.add(product);
    }
    public void displayProducts(){
        if(products.isEmpty()){
            System.out.println("Danh sách trống");
            return;
        }
        for(Product product:products){
            System.out.println(product.toString());;
        }
    }
    public void updateProduct(int id,int newQuantity) throws InvalidProductException{
        Optional<Product> product = products.stream().filter(p -> p.getId()==id).findFirst();
        if(product.isEmpty()){
            throw new InvalidProductException("Không tìm thấy sản phẩm");
        }
        product.get().setQuantity(newQuantity);
    }
    public void removeProduct(){
        products.removeIf(p->p.getQuantity()==0);
    }
}
