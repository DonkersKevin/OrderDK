package donkers.kevin.orderdk.domain.dto;

import donkers.kevin.orderdk.domain.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMapper {
    public ItemDto toItemDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getStock()
        );
    }

    public List<ItemDto> listToDtoList(List<Item> allItems) {
        return allItems.stream().map(this::toItemDto).toList();
    }

    public Item dtoToItem(ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getPrice(),
                itemDto.getStock()
        );
    }
}
