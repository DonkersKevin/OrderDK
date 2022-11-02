package donkers.kevin.orderdk.repositories;

import donkers.kevin.orderdk.domain.Item;
import donkers.kevin.orderdk.domain.ItemBatch;
import donkers.kevin.orderdk.domain.Order;
import donkers.kevin.orderdk.repositories.interfaces.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryFileImpl implements OrderRepository {

    private List<Order> orderList;

    public OrderRepositoryFileImpl() {
        this.orderList = new ArrayList<>(List.of(
                new Order("0", List.of(
                        new ItemBatch(new Item("1", "SamuraiPloes","A self sharpening knife", 50.0,4),2)
                ))
            )
        );
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public List<Order> getAllMyOrders(String userId) {
        //Todo
        return null;
    }

    @Override
    public Order getOrderById(String id) {
        return orderList.stream().filter(o -> o.getOrderId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public Order addOrder(Order order) {
        orderList.add(order);
        return order;
    }

    @Override
    public Order reCreateOrder(String orderId) {
        return null;
    }
}
