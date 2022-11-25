package donkers.kevin.orderdk.domain.Order.dto;

import donkers.kevin.orderdk.domain.Order.ItemBatch;

import java.util.List;

public class OrderResponse {

    private Long id;
    private double totalPrice;
    private List<ItemBatch> itemBatchList;

    public OrderResponse(Long id, double totalPrice, List<ItemBatch> itemBatchList) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.itemBatchList = itemBatchList;
    }
}

