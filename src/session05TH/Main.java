package session05TH;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidProductException {
        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();
        int choice;
        do{
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát chương trình");
            System.out.println("=============================================");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập mã định danh: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên sản phẩm: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập giá sản phẩm: ");
                    double price = sc.nextDouble();
                    System.out.println("Nhập số lượng tồn kho: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên danh mục: ");
                    String category = sc.nextLine();
                    Product product = new Product(id, name, price, quantity, category);
                    productService.addProduct(product);
                    System.out.println("Thêm thành công");
                    break;
                case 2:
                    productService.displayProducts();
                    break;
                case 3:
                    System.out.println("Nhập ID muốn sửa:");
                    int searchID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập số lượng mới: ");
                    int newquantity = sc.nextInt();
                    sc.nextLine();
                    productService.updateProduct(searchID, newquantity);
                    System.out.println("Cập nhập thành công!");
                    break;
                case 4:
                    productService.removeProduct();
                    System.out.println("Đã xóa sản phẩm hết hàng");
                    break;
                case 5:
                    System.out.println("Thoát chương trình thành công");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while (choice!=5);
    }
}
