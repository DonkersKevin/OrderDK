package donkers.kevin.orderdk.domain.Order.dto.order;

import donkers.kevin.orderdk.domain.Order.Order;
import donkers.kevin.orderdk.domain.Order.dto.itemBatch.ItemBatchMapper;
import donkers.kevin.orderdk.domain.Order.dto.itemBatch.NewItemBatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class OrderMapper {

    private ItemBatchMapper itemBatchMapper;

    public OrderMapper(ItemBatchMapper itemBatchMapper) {
        this.itemBatchMapper = itemBatchMapper;
    }

    public OrderResponse toOrderResponse(Order order) {
        log.info("mapping : Order -> OrderResponse");
        return new OrderResponse(
                order.getId(),
                order.getTotalPrice(),
                itemBatchMapper.toItemBatchResponseList(order.getItemBatchList())
        );
    }

    public List<OrderResponse> toOrderResponseList(List<Order> allOrders) {
        log.info("mapping : OrderList -> OrderResponseList");
        return allOrders.stream().map(this::toOrderResponse).toList();
    }

    public Order toOrder(NewOrder newOrder) {
        log.info("mapping : newOrder -> Order");
        return new Order(itemBatchMapper.toItemBatchList(newOrder.getNewItemBatchList()));
    }
}
