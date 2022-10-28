package donkers.kevin.orderdk.domain;

import java.util.List;

public class Order {
    private double totalPrice;
    private List<ItemBatch> itemBatchList;

    public Order(double totalPrice, List<ItemBatch> itemBatchList) {
        this.totalPrice = totalPrice;
        this.itemBatchList = itemBatchList;
    }
}
