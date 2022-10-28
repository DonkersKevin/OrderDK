package donkers.kevin.orderdk.controllers;

import donkers.kevin.orderdk.domain.dto.CustomerDto;
import donkers.kevin.orderdk.services.CustomerService;
import donkers.kevin.orderdk.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final CustomerService customerService;
    private SecurityService securityService;

    public CustomerController(CustomerService customerService, SecurityService securityService) {
        this.customerService = customerService;
        this.securityService = securityService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getAllCustomers(){
        log.info("Getting all customers...");
        return customerService.getAllCustomers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto getCustomerByID(@PathVariable String id){
        log.info("Getting customer by id : " + id);
        return customerService.getCustomerByID(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        log.info("Adding new customer...");
        return customerService.createCustomer(customerDto);
    }
}
