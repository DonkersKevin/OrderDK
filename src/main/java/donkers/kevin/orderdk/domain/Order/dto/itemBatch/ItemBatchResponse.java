package donkers.kevin.orderdk.domain.Order.dto.itemBatch;

import donkers.kevin.orderdk.domain.Item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ItemBatchResponse {

    private Long id;
    private Item item;
    private int amount;
    private LocalDate shippingDate;
    private double itemBatchPrice;
}
