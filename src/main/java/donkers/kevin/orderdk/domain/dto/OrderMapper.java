package donkers.kevin.orderdk.domain.dto;

import donkers.kevin.orderdk.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderDto toOrderDto(Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getTotalPrice(),
                order.getItemBatchList()
        );
    }

    public List<OrderDto> orderListToDtoList(List<Order> allOrders) {
        return allOrders.stream().map(this::toOrderDto).toList();
    }

    public Order dtoToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getItemBatchList()
        );
    }
}
