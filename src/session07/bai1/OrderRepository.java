package session07.bai1;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.getOrderId());
    }

    public Order findById(String id) {
        for (Order o : orders) {
            if (o.getOrderId().equals(id)) {
                return o;
            }
        }
        return null;
    }
}
