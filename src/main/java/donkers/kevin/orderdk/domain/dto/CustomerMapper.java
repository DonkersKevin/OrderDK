package donkers.kevin.orderdk.domain.dto;

import donkers.kevin.orderdk.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {
    public List<CustomerDto> toCustomerDtoList(List<Customer> allCustomers) {
        return allCustomers.stream().map(this::toCustomerDto).toList();
    }

    public CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhoneNumber());
    }

    //TODO probably wont need
    public List<Customer> DtotoCustomerList(List<CustomerDto> allCustomerDto) {
        return allCustomerDto.stream().map(this::DtoToCustomer).toList();
    }

    public Customer DtoToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getAddress(),
                customerDto.getPhoneNumber());
    }
}
