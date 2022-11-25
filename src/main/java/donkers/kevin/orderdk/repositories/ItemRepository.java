package donkers.kevin.orderdk.repositories;

import donkers.kevin.orderdk.domain.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
