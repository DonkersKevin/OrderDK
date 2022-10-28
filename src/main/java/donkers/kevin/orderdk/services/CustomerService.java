package donkers.kevin.orderdk.services;

import donkers.kevin.orderdk.domain.dto.CustomerDto;
import donkers.kevin.orderdk.domain.dto.CustomerMapper;
import donkers.kevin.orderdk.repositories.interfaces.CustomerRepository;
import donkers.kevin.orderdk.services.util.CustomerValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    private CustomerValidator customerValidator;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDto> getAllCustomers() {
       return customerMapper.toCustomerDtoList(customerRepository.getAllCustomers());
    }

    public CustomerDto getCustomerByID(String id) {
        return customerMapper.toCustomerDto(customerRepository.getCustomerById(id));
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        return customerMapper.toCustomerDto(customerRepository.addCustomer(customerMapper.DtoToCustomer(customerDto)));
    }
}
