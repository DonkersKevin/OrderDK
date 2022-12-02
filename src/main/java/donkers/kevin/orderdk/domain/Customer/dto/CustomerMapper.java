package donkers.kevin.orderdk.domain.Customer.dto;

import donkers.kevin.orderdk.domain.Customer.Customer;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CustomerMapper {

    public List<CustomerResponse> toCustomerResponseList(List<Customer> allCustomers) {
        log.info("mappiing : customer list");
        return allCustomers.stream().map(this::toCustomerResponse).toList();
    }

    //Customer response with builder pattern and lombok.
    public CustomerResponse toCustomerResponse(Customer customer) {
        log.info("mapping Customer -> CustomerResponse");
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    public Customer toCustomer(NewCustomer newCustomer){
        log.info("mapping : newCustomer -> Customer");
        return new Customer(
                newCustomer.getFirstName(),
                newCustomer.getLastName(),
                newCustomer.getEmail(),
                newCustomer.getAddress(),
                newCustomer.getPhoneNumber(),
                newCustomer.getRole(),
                newCustomer.getUserName()
        );
    }
}
