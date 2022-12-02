package donkers.kevin.orderdk.domain.Order.dto.order;

import donkers.kevin.orderdk.domain.Order.dto.itemBatch.NewItemBatch;
import lombok.Getter;

import java.util.List;

@Getter
public class NewOrder {
    private List<NewItemBatch> newItemBatchList;

    public NewOrder(List<NewItemBatch> itemBatchList) {
        this.newItemBatchList = itemBatchList;
    }
}

