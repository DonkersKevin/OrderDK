package donkers.kevin.orderdk.repositories.interfaces;

import donkers.kevin.orderdk.domain.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> getAllItems();

    Item getItemById(String id);

    Item addItem(Item item);
}
