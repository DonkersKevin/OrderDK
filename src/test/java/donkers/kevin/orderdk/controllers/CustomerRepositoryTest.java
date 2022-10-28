package donkers.kevin.orderdk.controllers;

import donkers.kevin.orderdk.domain.Customer;
import donkers.kevin.orderdk.repositories.interfaces.CustomerRepository;
import donkers.kevin.orderdk.repositories.CustomerRepositoryFileImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerRepositoryTest {

    @Test
    void AddCustomer_HappyPath() {
        //ARRANGE
        CustomerRepository customerRepository = new CustomerRepositoryFileImpl();

        List<Customer> expectedCustomers =
                List.of(new Customer(
                        "1",
                        "Mr",
                        "Smith",
                        "MrSmith@gmail.com",
                        "Manorstreet 22",
                        "0498 76 87 98")
                );

        Customer customerToAdd = new Customer("1", "Mr", "Smith", "MrSmith@gmail.com", "Manorstreet 22", "0498 76 87 98");

        //ACT
        customerRepository.addCustomer(customerToAdd);

        //ASSESS
        Assertions.assertEquals(expectedCustomers,customerRepository.getAllCustomers());
    }
}
