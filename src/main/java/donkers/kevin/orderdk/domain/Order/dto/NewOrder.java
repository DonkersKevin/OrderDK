package donkers.kevin.orderdk.domain.Order.dto;

import donkers.kevin.orderdk.domain.Order.ItemBatch;
import lombok.Getter;

import java.util.List;

@Getter
public class NewOrder {
    private List<ItemBatch> itemBatchList;


    public NewOrder(List<ItemBatch> itemBatchList) {
        this.itemBatchList = itemBatchList;
    }
}

