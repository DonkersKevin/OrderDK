package donkers.kevin.orderdk.domain.dto;

import donkers.kevin.orderdk.domain.ItemBatch;

import java.util.List;

public class OrderDto {

    private final String orderId;
    private double totalPrice;
    private List<ItemBatch> itemBatchList;

    public OrderDto(String orderId, double totalPrice, List<ItemBatch> itemBatchList) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.itemBatchList = itemBatchList;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<ItemBatch> getItemBatchList() {
        return itemBatchList;
    }
}
