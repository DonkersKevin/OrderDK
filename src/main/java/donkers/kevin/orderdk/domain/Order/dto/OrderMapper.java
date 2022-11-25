package donkers.kevin.orderdk.domain.Order.dto;

import donkers.kevin.orderdk.domain.Order.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderResponse toOrderResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getTotalPrice(),
                order.getItemBatchList()
        );
    }

    public List<OrderResponse> toOrderResponseList(List<Order> allOrders) {
        return allOrders.stream().map(this::toOrderResponse).toList();
    }

    public Order toOrder(NewOrder newOrder) {
        return new Order(
                newOrder.getItemBatchList()
        );
    }
}
