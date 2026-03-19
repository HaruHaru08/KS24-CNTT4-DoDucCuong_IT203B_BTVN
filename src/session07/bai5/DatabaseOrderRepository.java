package session07.bai5;

import java.util.*;

public class DatabaseOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public void save(Order order){
        orders.add(order);
        System.out.println("Lưu đơn hàng vào database: " + order.getId());
    }

    public List<Order> findAll(){
        return orders;
    }
}
