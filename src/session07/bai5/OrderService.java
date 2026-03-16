package session07.bai5;

import java.util.*;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repo, NotificationService notify){
        this.repository = repo;
        this.notification = notify;
    }

    public void createOrder(Order order, DiscountStrategy discount, PaymentMethod payment){
        double total = 0;
        for(OrderItem item : order.getItems()){
            total += item.getSubtotal();
        }

        double finalAmount = discount.applyDiscount(total);

        order.setFinalAmount(finalAmount);

        payment.pay(finalAmount);

        repository.save(order);

        notification.send(
                "Đơn hàng " + order.getId() + " đã được tạo",
                order.getCustomer().getEmail()
        );
    }

    public List<Order> getOrders(){
        return repository.findAll();
    }
}
