package donkers.kevin.orderdk.domain.Order;

import donkers.kevin.orderdk.domain.Item.Item;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "ITEMBATCHES")
@Getter
public class ItemBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_item_id")
    private Item item;
    private int amount;
    private LocalDate shippingDate;
    private double itemBatchPrice;

    public ItemBatch() {
    }

    public ItemBatch(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = LocalDate.now().plusDays(1L);
        this.itemBatchPrice = calculateBatchPrice();
    }

    private double calculateBatchPrice() {
        return item.getPrice().getUnitPrice() * amount;
    }


}
