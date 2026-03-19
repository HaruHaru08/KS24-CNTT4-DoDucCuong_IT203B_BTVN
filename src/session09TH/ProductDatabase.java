package session09TH;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase() {
        products = new ArrayList<>();
    }

    public static synchronized ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Đã thêm sản phẩm thành công.");
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (Product product : products) {
                product.displayInfo();
            }
        }
    }

    public void removeProduct(String id) {
        boolean removed = products.removeIf(product -> product.getId().equals(id));
        if (removed) {
            System.out.println("Đã xóa sản phẩm có mã: " + id);
        } else {
            System.out.println("Không tìm thấy sản phẩm để xóa.");
        }
    }

    public void updateProduct(String id, String newName, double newPrice) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName(newName);
                product.setPrice(newPrice);
                System.out.println("Đã cập nhật sản phẩm có mã: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã: " + id);
    }
}
