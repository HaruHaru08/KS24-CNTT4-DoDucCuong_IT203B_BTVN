package session07.bai6;

import java.util.List;

public interface OrderRepository {
    void save(Order order);

    List<Order> findAll();
}
