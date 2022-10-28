package donkers.kevin.orderdk.repositories;


import donkers.kevin.orderdk.domain.Customer;
import donkers.kevin.orderdk.repositories.interfaces.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryFileImpl implements CustomerRepository {
    private List<Customer> customerList;

    public CustomerRepositoryFileImpl() {
        this.customerList = new ArrayList<>(List.of(
                new Customer("1", "Mr", "Smith", "MrSmith@gmail.com", "Manorstreet 22", "0498 76 87 98")
        ));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerList;
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerList.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public Customer addCustomer(Customer customer) {
       customerList.add(customer);
       return customer;
    }
}
