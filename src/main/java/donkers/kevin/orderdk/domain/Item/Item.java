package donkers.kevin.orderdk.domain.Item;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ITEMS")
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "item_name")
    private String name;
    @NotBlank
    @Column(name = "item_description")
    private String description;

    //Todo see if Money class can be applied
    @Embedded
    private Price price;
    private int stock;

    public Item() {
    }

    public Item(String name, String description, Price price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Item(Long id, String name, String description, Price price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
