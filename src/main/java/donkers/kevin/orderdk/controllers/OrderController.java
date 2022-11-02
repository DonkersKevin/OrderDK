package donkers.kevin.orderdk.controllers;

import donkers.kevin.orderdk.domain.Order;
import donkers.kevin.orderdk.domain.dto.OrderDto;
import donkers.kevin.orderdk.repositories.interfaces.OrderRepository;
import donkers.kevin.orderdk.security.SecurityService;
import donkers.kevin.orderdk.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final OrderService orderService;

    private final SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping
    public List<OrderDto> getMyOrders(){
        //Todo
        return null;
    }

    @PostMapping
    public OrderDto createOrder(){
        //Todo
        return null;
    }

    @PostMapping(value = "/{orderId}")
    public OrderDto reOrder(){
        //Todo
        return null;
    }


}
