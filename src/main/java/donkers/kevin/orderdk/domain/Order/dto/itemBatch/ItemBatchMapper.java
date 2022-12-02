package donkers.kevin.orderdk.domain.Order.dto.itemBatch;

import donkers.kevin.orderdk.domain.Order.ItemBatch;
import donkers.kevin.orderdk.exceptions.NoSuchItemException;
import donkers.kevin.orderdk.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ItemBatchMapper {
    private ItemRepository itemRepository;

    public ItemBatchMapper(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    private ItemBatch toItemBatch(NewItemBatch newItemBatch){
        log.info("mapping : NewItemBatch -> ItemBatch");
        return new ItemBatch(
                itemRepository.findById(newItemBatch.getItemId()).orElseThrow(NoSuchItemException::new),
                newItemBatch.getAmount()
        );
    }
    public List<ItemBatch> toItemBatchList(List<NewItemBatch> newItemBatchList) {
        log.info("mapping : NewItemBatchList - > ItemBatchList");
        return newItemBatchList.stream().map(this::toItemBatch).toList();
    }


    public ItemBatchResponse toItemBatchResponse(ItemBatch itemBatch){
        log.info("mapping : Itembatch - > ItemBatchresponse");

        return new ItemBatchResponse(
                itemBatch.getId(),
                itemBatch.getItem(),
                itemBatch.getAmount(),
                itemBatch.getShippingDate(),
                itemBatch.getItemBatchPrice()
        );
    }
    public List<ItemBatchResponse> toItemBatchResponseList(List<ItemBatch> itemBatchList){
        log.info("mapping : ItemBatchList - > ItemBatchListResponse");
        return itemBatchList.stream().map(this::toItemBatchResponse).toList();
    }
}
