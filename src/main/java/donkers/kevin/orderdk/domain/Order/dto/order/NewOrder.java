package donkers.kevin.orderdk.domain.Order.dto.order;

import donkers.kevin.orderdk.domain.Order.dto.itemBatch.NewItemBatch;
import lombok.Getter;

import java.util.List;

@Getter
public class NewOrder {
    private List<NewItemBatch> newItemBatchList;
    private Long CustomerId;
    public NewOrder(List<NewItemBatch> newItemBatchList, Long customerId) {
        this.newItemBatchList = newItemBatchList;
        CustomerId = customerId;
    }

    @Override
    public String toString() {
        return "NewOrder{" +
                "newItemBatchList=" + newItemBatchList +
                ", CustomerId=" + CustomerId +
                '}';
    }
}

