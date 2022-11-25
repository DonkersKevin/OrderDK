package donkers.kevin.orderdk.controllers;

import donkers.kevin.orderdk.domain.Order.dto.NewOrder;
import donkers.kevin.orderdk.domain.Order.dto.OrderDto;
import donkers.kevin.orderdk.domain.Order.dto.OrderResponse;
import donkers.kevin.orderdk.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderResponse> getAllOrders(){
        log.info("Getting all orders...");
        return orderService.getAllOrders();
    }

    /*
    @GetMapping
    public List<OrderDto> getMyOrders(){
        //Todo
        return null;
    }

     */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderResponse createOrder(@RequestBody NewOrder newOrder){
        log.info("Creating new Order...");
        return orderService.createOrder(newOrder);
    }


    @PostMapping(value = "/{orderId}")
    public OrderDto reOrder(){
        //Todo
        return null;
    }


}
