package donkers.kevin.orderdk.services;

import donkers.kevin.orderdk.domain.dto.ItemDto;
import donkers.kevin.orderdk.domain.dto.ItemMapper;
import donkers.kevin.orderdk.repositories.interfaces.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto getItemById(String id) {
        return itemMapper.toItemDto(itemRepository.getItemById(id));
    }

    public ItemDto addItem(ItemDto itemDto) {
        return itemMapper.toItemDto(itemRepository.addItem(itemMapper.dtoToItem(itemDto)));
    }

    public List<ItemDto> getAllItems() {
        return itemMapper.listToDtoList(itemRepository.getAllItems());
    }
}
