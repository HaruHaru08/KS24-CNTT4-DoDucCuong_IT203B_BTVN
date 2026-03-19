package session07.bai4;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notificationService;

    public OrderService(OrderRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order){
        repository.save(order);
        notificationService.send(
                "Đơn hàng " + order.getId() + " đã được tạo",
                "customer"
        );
    }
}
