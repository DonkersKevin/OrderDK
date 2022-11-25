package donkers.kevin.orderdk.domain.Order;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "totalprice")
    private double totalPrice;

    @OneToMany(mappedBy = "order")
    private List<ItemBatch> itemBatchList;

    public Order() {
    }

    public Order(Long id, List<ItemBatch> itemBatchList) {
        this.id = id;
        this.totalPrice = calcOrderTotalPrice();
        this.itemBatchList = itemBatchList;
    }

    public Order(List<ItemBatch> itemBatchList) {
        this.totalPrice = calcOrderTotalPrice();
        this.itemBatchList = itemBatchList;
    }

    private double calcOrderTotalPrice(){
        return itemBatchList.stream().mapToDouble(ItemBatch::getItemBatchPrice).sum();
    }
}
