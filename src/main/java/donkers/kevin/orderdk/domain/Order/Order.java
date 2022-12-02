package donkers.kevin.orderdk.domain.Order;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Data
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemBatch> itemBatchList;

    public Order() {
    }

    public Order(Long id, List<ItemBatch> itemBatchList) {
        this.id = id;
        this.itemBatchList = itemBatchList;
        this.totalPrice = calcOrderTotalPrice();
    }

    public Order(List<ItemBatch> itemBatchList) {
        this.itemBatchList = itemBatchList;
        this.totalPrice = calcOrderTotalPrice();
    }

    private double calcOrderTotalPrice(){
        return itemBatchList.stream().mapToDouble(ItemBatch::getItemBatchPrice).sum();
    }
}
