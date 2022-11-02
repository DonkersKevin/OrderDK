package donkers.kevin.orderdk.repositories;

import donkers.kevin.orderdk.domain.ItemBatch;
import donkers.kevin.orderdk.domain.Order;
import donkers.kevin.orderdk.repositories.interfaces.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryFileImpl implements OrderRepository {

    private List<Order> orders;

    public OrderRepositoryFileImpl() {
        this.orders = new ArrayList<>(List.of(
                new Order("1", new ArrayList<ItemBatch>())
            )
        );
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> getAllMyOrders(String userId) {
        return null;
    }

    @Override
    public Order getOrderById(String id) {
        return null;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order reCreateOrder(String orderId) {
        return null;
    }
}
