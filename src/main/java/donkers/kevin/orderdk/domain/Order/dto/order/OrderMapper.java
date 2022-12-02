package donkers.kevin.orderdk.domain.Order.dto.order;

import donkers.kevin.orderdk.domain.Order.Order;
import donkers.kevin.orderdk.domain.Order.dto.itemBatch.ItemBatchMapper;
import donkers.kevin.orderdk.exceptions.NoSuchCustomerException;
import donkers.kevin.orderdk.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OrderMapper {

    private ItemBatchMapper itemBatchMapper;
    private CustomerRepository customerRepository;

    public OrderMapper(ItemBatchMapper itemBatchMapper, CustomerRepository customerRepository) {
        this.itemBatchMapper = itemBatchMapper;
        this.customerRepository = customerRepository;
    }

    public OrderResponse toOrderResponse(Order order) {
        System.out.println(order);
        log.info("mapping : Order -> OrderResponse");
        return new OrderResponse(
                order.getId(),
                order.getTotalPrice(),
                itemBatchMapper.toItemBatchResponseList(order.getItemBatchList()),
                order.getCustomer().getId()
        );
    }

    public List<OrderResponse> toOrderResponseList(List<Order> allOrders) {
        log.info("mapping : OrderList -> OrderResponseList");
        return allOrders.stream().map(this::toOrderResponse).toList();
    }

    public Order toOrder(NewOrder newOrder) {
        log.info("mapping : newOrder -> Order");
        return new Order(
                itemBatchMapper.toItemBatchList(newOrder.getNewItemBatchList()),
                customerRepository.findById(newOrder.getCustomerId()).orElseThrow(NoSuchCustomerException::new)
        );
    }
}
