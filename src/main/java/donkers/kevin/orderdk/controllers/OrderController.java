package donkers.kevin.orderdk.controllers;

import donkers.kevin.orderdk.domain.Order.dto.order.NewOrder;
import donkers.kevin.orderdk.domain.Order.dto.order.OrderDto;
import donkers.kevin.orderdk.domain.Order.dto.order.OrderResponse;
import donkers.kevin.orderdk.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('CAN_VIEW_ALL_ORDERS')")
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
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
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
