package donkers.kevin.orderdk.domain;

import java.util.List;

public class Order {
    private final String orderId;
    private double totalPrice;
    private List<ItemBatch> itemBatchList;

    public Order(String orderId, List<ItemBatch> itemBatchList) {
        this.orderId = orderId;
        this.totalPrice = calcOrderTotalPrice();
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

    private double calcOrderTotalPrice(){
        return itemBatchList.stream().mapToDouble(ItemBatch::getItemBatchPrice).sum();
    }
}
