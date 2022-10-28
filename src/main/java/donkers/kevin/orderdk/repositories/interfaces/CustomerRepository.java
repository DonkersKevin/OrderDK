package donkers.kevin.orderdk.repositories.interfaces;

import donkers.kevin.orderdk.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomers();

    Customer getCustomerById(String id);

    Customer addCustomer(Customer customer);
}
