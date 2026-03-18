package session09TH;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDatabase productDatabase = new ProductDatabase();
        Scanner sc =new Scanner(System.in);
        int choice;
        do{
            System.out.println("---------- Quản lý sản phẩm ----------");
            System.out.println("1.Thêm mới sản phẩm");
            System.out.println("2.Xem danh sách sản phẩm");
            System.out.println("3.Cập nhập thông tin sản phẩm");
            System.out.println("4.Xóa sản phẩm");
            System.out.println("5.Thoát");
            System.out.println("--------------------------------------");
            System.out.print("Lựa chọn của bạn: ");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Thêm mới sản phẩm");
                    System.out.println("1.Sản phẩm vật lý");
                    System.out.println("2.Sản phẩm điện tử");
                    System.out.print("Nhập lựa chọn sản phẩm muốn thêm mới: ");
                    int productType=sc.nextInt();
                    System.out.println("Nhập mã sản phẩm: ");
                    String id=sc.next();
                    System.out.println("Nhập tên sản phẩm: ");
                    String name=sc.next();
                    System.out.println("Nhập giá sản phẩm: ");
                    double price=sc.nextDouble();
                    if (productType==1){
                        System.out.println("Nhập trọng lượng sản phẩm: ");
                        double weight=sc.nextDouble();
                        sc.nextLine();
                        PhysicalProduct physicalProduct=new PhysicalProduct(id, name, price, weight);
                        productDatabase.addProduct(physicalProduct);
                    }else if (productType==2){
                        System.out.println("Nhập kích thước sản phẩm: ");
                        double size=sc.nextDouble();
                        sc.nextLine();
                        DigitalProduct digitalProduct=new DigitalProduct(id, name, price, size);
                        productDatabase.addProduct(digitalProduct);
                    }
                    break;
                case 2:
                    System.out.println("Danh sách sản phẩm");
                    productDatabase.displayProducts();
                    break;
                case 3:
                    System.out.println("Cập nhập thông tin sản phẩm");
                    System.out.println("Nhập mã sản phẩm muốn sửa: ");
                    String idUpdate=sc.nextLine();
                    System.out.println("Nhập tên mới: ");
                    String newName = sc.nextLine();
                    System.out.println("Nhập giá mới: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();
                    Product updatedProduct = new PhysicalProduct(); 
                    updatedProduct.setName(newName);
                    updatedProduct.setPrice(newPrice);
                    productDatabase.updateProduct(idUpdate, updatedProduct);
                    break;
                case 4:
                    System.out.println("Xóa sản phẩm");
                    System.out.println("Nhập mã sản phẩm muốn xóa: ");
                    String idDelete=sc.nextLine();
                    productDatabase.removeProduct(idDelete);
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while (choice!=5);
    }
}
