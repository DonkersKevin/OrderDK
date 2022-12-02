package donkers.kevin.orderdk.domain.Item.dto;

import donkers.kevin.orderdk.domain.Item.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ItemMapper {

    public Item toItem(NewItem newItem){
        log.info("mapping : newItem -> Item");
        return new Item(
                newItem.getName(),
                newItem.getDescription(),
                newItem.getPrice(),
                newItem.getStock()
        );
    }

    public ItemResponse toItemResponse(Item item){
        log.info("mapping : Item -> ItemResponse");
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
