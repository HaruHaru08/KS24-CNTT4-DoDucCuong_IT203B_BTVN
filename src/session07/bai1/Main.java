package session07.bai1;

import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo sản phẩm
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuột", 300000);

        System.out.println("Tạo sản phẩm: SP01 - Laptop - 15000000, SP02 - Chuột - 300000");
        System.out.println("Đã thêm sản phẩm SP01, SP02");

        // Tạo khách hàng
        Customer customer = new Customer("Nguyễn Văn A", "a@example.com", "Hà Nội");
        System.out.println("Tạo khách hàng: Nguyễn Văn A - a@example.com");
        System.out.println("Đã thêm khách hàng");

        // Tạo đơn hàng
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(p1, 1));
        items.add(new OrderItem(p2, 2));

        Order order = new Order("ORD001", customer, items);

        System.out.println("Tạo đơn hàng: SP01 (1 cái), SP02 (2 cái)");
        System.out.println("Đơn hàng ORD001 được tạo");

        // Tính tổng tiền
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);
        order.setTotal(total);

        System.out.println("Tính tổng tiền");
        System.out.println("Tổng tiền: " + NumberFormat.getInstance().format(total));

        // Lưu đơn hàng
        OrderRepository repository = new OrderRepository();
        System.out.println("Lưu đơn hàng");
        repository.save(order);

        // Gửi email
        EmailService emailService = new EmailService();
        System.out.println("Gửi email xác nhận");
        emailService.sendOrderConfirmation(customer, order);
    }
}
