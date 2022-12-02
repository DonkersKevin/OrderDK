package donkers.kevin.orderdk.services;

import donkers.kevin.orderdk.domain.Customer.Customer;
import donkers.kevin.orderdk.domain.Customer.dto.CustomerResponse;
import donkers.kevin.orderdk.domain.Customer.dto.CustomerMapper;
import donkers.kevin.orderdk.domain.Customer.dto.NewCustomer;
import donkers.kevin.orderdk.exceptions.NoSuchCustomerException;
import donkers.kevin.orderdk.repositories.CustomerRepository;
import donkers.kevin.orderdk.security.KeycloakService;
import donkers.kevin.orderdk.security.KeycloakUserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final KeycloakService keycloakService;

    public List<CustomerResponse> getAllCustomers() {

       return customerMapper.toCustomerResponseList(customerRepository.findAll());
    }

    public CustomerResponse getCustomerByID(String id) {
        return customerMapper.toCustomerResponse(customerRepository.findById(Long.valueOf(id)).orElseThrow(NoSuchCustomerException::new));
    }

    public CustomerResponse createCustomer(NewCustomer newCustomer) {
        //Todo provide field checks
        //Todo Check duplicates

        //Ad
        keycloakService.addUser(new KeycloakUserDTO(newCustomer.getUserName(), newCustomer.getPassword(), newCustomer.getRole()));
        Customer savedCustomer = customerRepository.save(customerMapper.toCustomer(newCustomer));

        return customerMapper.toCustomerResponse(savedCustomer);
    }
}
