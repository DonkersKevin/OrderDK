package donkers.kevin.orderdk.domain.Item.dto;

import donkers.kevin.orderdk.domain.Item.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMapper {

    public Item toItem(NewItem newItem){
        return new Item(
                newItem.getName(),
                newItem.getDescription(),
                newItem.getPrice(),
                newItem.getStock()
        );
    }

    public ItemResponse toItemResponse(Item item){
        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getStock()
        );
    }

    public List<ItemResponse> toItemResponseList(List<Item> allItems) {
        return allItems.stream().map(this::toItemResponse).toList();
    }
}
