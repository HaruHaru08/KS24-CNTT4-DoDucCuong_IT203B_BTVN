package session09TH;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDatabase productDatabase = ProductDatabase.getInstance();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---------- Quản lý sản phẩm ----------");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("--------------------------------------");
            System.out.print("Lựa chọn của bạn: ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Lựa chọn không hợp lệ. Vui lòng nhập số: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("--- Thêm mới sản phẩm ---");
                    System.out.println("1. Sản phẩm vật lý");
                    System.out.println("2. Sản phẩm kỹ thuật số");
                    System.out.print("Nhập lựa chọn loại sản phẩm: ");
                    int productType = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhập mã sản phẩm: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price = sc.nextDouble();
                    
                    double additionalAttribute = 0;
                    if (productType == 1) {
                        System.out.print("Nhập trọng lượng sản phẩm (weight): ");
                        additionalAttribute = sc.nextDouble();
                    } else if (productType == 2) {
                        System.out.print("Nhập dung lượng sản phẩm (size in MB): ");
                        additionalAttribute = sc.nextDouble();
                    }
                    sc.nextLine(); // Consume newline

                    Product newProduct = ProductFactory.createProduct(productType, id, name, price, additionalAttribute);
                    if (newProduct != null) {
                        productDatabase.addProduct(newProduct);
                    } else {
                        System.out.println("Loại sản phẩm không hợp lệ.");
                    }
                    break;
                case 2:
                    System.out.println("--- Danh sách sản phẩm ---");
                    productDatabase.displayProducts();
                    break;
                case 3:
                    System.out.println("--- Cập nhật thông tin sản phẩm ---");
                    System.out.print("Nhập mã sản phẩm muốn sửa: ");
                    String idUpdate = sc.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = sc.nextLine();
                    System.out.print("Nhập giá mới: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();

                    productDatabase.updateProduct(idUpdate, newName, newPrice);
                    break;
                case 4:
                    System.out.println("--- Xóa sản phẩm ---");
                    System.out.print("Nhập mã sản phẩm muốn xóa: ");
                    String idDelete = sc.nextLine();
                    productDatabase.removeProduct(idDelete);
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);
    }
}
