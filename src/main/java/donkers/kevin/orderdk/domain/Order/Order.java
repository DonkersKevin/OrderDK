package donkers.kevin.orderdk.domain.Order;

import donkers.kevin.orderdk.domain.Customer.Customer;
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

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_order_id")
    private List<ItemBatch> itemBatchList;

    @ManyToOne
    @JoinColumn(name = "fk_customer_id")
    private Customer customer;

    public Order() {
    }

    public Order(Long id, List<ItemBatch> itemBatchList, Customer customer) {
        this.id = id;
        this.itemBatchList = itemBatchList;
        this.totalPrice = calcOrderTotalPrice();
        this.customer = customer;
    }

    public Order(List<ItemBatch> itemBatchList, Customer customer) {
        this.itemBatchList = itemBatchList;
        this.totalPrice = calcOrderTotalPrice();
        this.customer = customer;
    }

    private double calcOrderTotalPrice(){
        return itemBatchList.stream().mapToDouble(ItemBatch::getItemBatchPrice).sum();
    }
}
