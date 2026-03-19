package session07.bai6;

public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void createOrder(
            Order order,
            DiscountStrategy discount,
            PaymentMethod payment,
            NotificationService notification) {

        double total = 0;

        for (OrderItem item : order.getItems()) {
            total += item.getSubtotal();
        }

        double finalAmount = discount.applyDiscount(total);

        order.setFinalAmount(finalAmount);

        payment.pay(finalAmount);

        repository.save(order);

        notification.send(
                "Đơn hàng " + order.getId() + " thành công",
                order.getCustomer().getEmail()
        );
    }
}
