package donkers.kevin.orderdk.services;

import donkers.kevin.orderdk.domain.Customer.dto.CustomerResponse;
import donkers.kevin.orderdk.domain.Customer.dto.CustomerMapper;
import donkers.kevin.orderdk.domain.Customer.dto.NewCustomer;
import donkers.kevin.orderdk.exceptions.NoSuchCustomerException;
import donkers.kevin.orderdk.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerResponse> getAllCustomers() {
       return customerMapper.toCustomerResponseList(customerRepository.findAll());
    }

    public CustomerResponse getCustomerByID(String id) {
        return customerMapper.toCustomerResponse(customerRepository.findById(Long.valueOf(id)).orElseThrow(NoSuchCustomerException::new));
    }

    public CustomerResponse createCustomer(NewCustomer newCustomer) {
        //Todo provide field checks
        return customerMapper.toCustomerResponse(customerRepository.save(customerMapper.toCustomer(newCustomer)));
    }
}
