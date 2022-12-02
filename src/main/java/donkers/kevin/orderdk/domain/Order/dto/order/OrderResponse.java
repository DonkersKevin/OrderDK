package donkers.kevin.orderdk.domain.Order.dto.order;

import donkers.kevin.orderdk.domain.Order.ItemBatch;
import donkers.kevin.orderdk.domain.Order.dto.itemBatch.ItemBatchResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderResponse {
    private Long id;
    private double totalPrice;
    private List<ItemBatchResponse> itemBatchList;

    public OrderResponse(Long id, double totalPrice, List<ItemBatchResponse> itemBatchList) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.itemBatchList = itemBatchList;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", itemBatchList=" + itemBatchList +
                '}';
    }
}

