package donkers.kevin.orderdk.repositories.interfaces;

import donkers.kevin.orderdk.domain.Order;

import java.util.List;

public interface OrderRepository {

    public List<Order> getAllOrders();

    public List<Order> getAllMyOrders(String userId);

    public Order getOrderById(String id);

    public Order createOrder(Order order);

    public Order reCreateOrder(String orderId);
}
