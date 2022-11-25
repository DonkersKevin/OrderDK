package donkers.kevin.orderdk.services;


import donkers.kevin.orderdk.domain.Item.dto.ItemMapper;
import donkers.kevin.orderdk.domain.Item.dto.ItemResponse;
import donkers.kevin.orderdk.domain.Item.dto.NewItem;
import donkers.kevin.orderdk.exceptions.NoSuchItemException;
import donkers.kevin.orderdk.repositories.ItemRepository;
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

    public ItemResponse getItemById(String id) {
        return itemMapper.toItemResponse(itemRepository.findById(Long.valueOf(id)).orElseThrow(NoSuchItemException::new));
    }

    public ItemResponse addItem(NewItem newItem) {
        //checkItemRequiredFields(newItem);
        return itemMapper.toItemResponse(itemRepository.save(itemMapper.toItem(newItem)));
    }

    public List<ItemResponse> getAllItems() {
        return itemMapper.toItemResponseList(itemRepository.findAll());
    }
}
