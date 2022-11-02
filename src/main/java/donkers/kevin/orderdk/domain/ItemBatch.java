package donkers.kevin.orderdk.domain;

import java.time.LocalDate;

public class ItemBatch {

    private final Item item;
    private int amount;
    private LocalDate shippingDate;
    private double itemBatchPrice;

    public ItemBatch(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = LocalDate.now().plusDays(1L);
        this.itemBatchPrice = calculateBatchPrice();
    }

    private double calculateBatchPrice() {
        return item.getPrice() * amount;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public double getItemBatchPrice() {
        return itemBatchPrice;
    }
}
