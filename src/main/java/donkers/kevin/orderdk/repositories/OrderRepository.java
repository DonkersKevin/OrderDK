package donkers.kevin.orderdk.repositories;

import donkers.kevin.orderdk.domain.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
