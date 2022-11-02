package donkers.kevin.orderdk.services;

import donkers.kevin.orderdk.domain.Order;
import donkers.kevin.orderdk.domain.dto.OrderDto;
import donkers.kevin.orderdk.domain.dto.OrderMapper;
import donkers.kevin.orderdk.repositories.interfaces.OrderRepository;
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

    public List<OrderDto> getAllOrders() {
        return orderMapper.orderListToDtoList(orderRepository.getAllOrders());
    }

    public OrderDto OrderToDto(Order order){
        return orderMapper.toOrderDto(order);
    }
}
