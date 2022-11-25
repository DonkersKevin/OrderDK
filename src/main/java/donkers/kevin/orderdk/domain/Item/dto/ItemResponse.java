package donkers.kevin.orderdk.domain.Item.dto;

import donkers.kevin.orderdk.domain.Item.Price;
import lombok.Getter;

@Getter
public class ItemResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final Price price;
    private int stock;

    public ItemResponse(Long id, String name, String description, Price price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
