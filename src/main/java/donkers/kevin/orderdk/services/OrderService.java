package donkers.kevin.orderdk.services;

import donkers.kevin.orderdk.domain.Order.dto.order.NewOrder;
import donkers.kevin.orderdk.domain.Order.dto.order.OrderMapper;
import donkers.kevin.orderdk.domain.Order.dto.order.OrderResponse;
import donkers.kevin.orderdk.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderResponse> getAllOrders() {
        return orderMapper.toOrderResponseList(orderRepository.findAll());
    }

    public OrderResponse createOrder(NewOrder newOrder) {
        return orderMapper.toOrderResponse(orderRepository.save(orderMapper.toOrder(newOrder)));
    }
}
