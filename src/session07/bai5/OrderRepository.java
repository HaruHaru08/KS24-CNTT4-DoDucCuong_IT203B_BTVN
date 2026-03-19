package session07.bai5;

import java.util.List;

public interface OrderRepository {
    void save(Order order);

    List<Order> findAll();
}
