package jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

    @Column(name = "ORDER_ITEM_ID")
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    private long orderPrice;
    private int count;

    public OrderItem() {
    }

    public OrderItem(final Long id,
                     final Item item,
                     final long orderPrice,
                     final int count) {
        this.id = id;
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public long getOrderPrice() {
        return orderPrice;
    }

    public int getCount() {
        return count;
    }
}
