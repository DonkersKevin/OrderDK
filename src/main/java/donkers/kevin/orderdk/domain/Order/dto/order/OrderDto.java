package donkers.kevin.orderdk.domain.Order.dto.order;

import donkers.kevin.orderdk.domain.Order.ItemBatch;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderDto {

    private Long id;
    private double totalPrice;
    private List<ItemBatch> itemBatchList;

    public OrderDto(Long id, double totalPrice, List<ItemBatch> itemBatchList) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.itemBatchList = itemBatchList;
    }
}
