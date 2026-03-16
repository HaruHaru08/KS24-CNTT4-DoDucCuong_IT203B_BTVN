package session07.bai6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("\n===== CHỌN KÊNH BÁN =====");
            System.out.println("1. Website");
            System.out.println("2. Mobile App");
            System.out.println("3. POS");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn kênh: ");
            int channel = sc.nextInt();
            sc.nextLine();

            if (channel == 0) {
                System.out.println("Thoát hệ thống");
                break;
            }

            SalesChannelFactory factory = null;

            switch (channel) {
                case 1:
                    factory = new WebsiteFactory();
                    break;

                case 2:
                    factory = new MobileAppFactory();
                    break;

                case 3:
                    factory = new StorePOSFactory();
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    continue;
            }

            System.out.println("\nBạn đã chọn kênh " + factory.getChannelName());

            DiscountStrategy discount = factory.createDiscount();
            PaymentMethod payment = factory.createPayment();
            NotificationService notification = factory.createNotification();

            System.out.println("\nTạo đơn hàng (" + factory.getChannelName() + ")");

            System.out.print("Nhập tên sản phẩm: ");
            String product = sc.nextLine();

            if (channel == 1) {

                System.out.print("Nhập mã giảm giá: ");
                String code = sc.nextLine();

                System.out.println("Áp dụng giảm giá 10% cho đơn hàng website");
            }

            if (channel == 2) {

                System.out.print("Có phải lần đầu mua? (yes/no): ");
                sc.nextLine();

                System.out.println("Áp dụng giảm giá 15% cho lần đầu");
            }

            if (channel == 3) {

                System.out.println("Áp dụng giảm giá tại cửa hàng");
            }

            System.out.println("\nThanh toán: " + payment.getName());

            payment.pay(1000000);

            notification.send(
                    "Đơn hàng thành công",
                    "customer"
            );

        }

    }
}