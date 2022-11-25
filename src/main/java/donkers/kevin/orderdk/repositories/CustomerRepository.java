package donkers.kevin.orderdk.repositories;

import donkers.kevin.orderdk.domain.Customer.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
