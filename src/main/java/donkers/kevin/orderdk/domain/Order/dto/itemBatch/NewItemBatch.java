package donkers.kevin.orderdk.domain.Order.dto.itemBatch;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewItemBatch {
    private Long itemId;
    private int amount;
}
