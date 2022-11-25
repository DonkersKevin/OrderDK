package donkers.kevin.orderdk.domain.Customer.dto;

import donkers.kevin.orderdk.domain.Customer.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {
    public List<CustomerResponse> toCustomerResponseList(List<Customer> allCustomers) {
        return allCustomers.stream().map(this::toCustomerResponse).toList();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhoneNumber());
    }

    public Customer toCustomer(NewCustomer newCustomer){
        return new Customer(
                newCustomer.getFirstName(),
                newCustomer.getLastName(),
                newCustomer.getEmail(),
                newCustomer.getAddress(),
                newCustomer.getPhoneNumber()
        );
    }

}
