package donkers.kevin.orderdk.repositories;

import donkers.kevin.orderdk.domain.Item;
import donkers.kevin.orderdk.repositories.interfaces.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepositoryFileImpl implements ItemRepository {
    private List<Item> itemList;

    public ItemRepositoryFileImpl(List<Item> itemList) {
        this.itemList = new ArrayList<>(List.of(
                        new Item("1", "SamuraiPloes","A self sharpening knife", 50.0,4)
                ));
    }

    @Override
    public List<Item> getAllItems() {
       return itemList;
    }

    @Override
    public Item getItemById(String id) {
       return itemList.stream().filter(i -> i.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public Item addItem(Item item) {
        itemList.add(item);
        return item;
    }
}
