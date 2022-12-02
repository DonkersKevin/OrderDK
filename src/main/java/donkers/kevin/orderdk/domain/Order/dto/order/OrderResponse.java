package donkers.kevin.orderdk.domain.Order.dto.order;

import donkers.kevin.orderdk.domain.Order.dto.itemBatch.ItemBatchResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderResponse {
    private Long id;
    private double totalPrice;
    private List<ItemBatchResponse> itemBatchList;

    private Long customerId;

    public OrderResponse(Long id, double totalPrice, List<ItemBatchResponse> itemBatchList, Long customerId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.itemBatchList = itemBatchList;
        this.customerId = customerId;
    }
}

