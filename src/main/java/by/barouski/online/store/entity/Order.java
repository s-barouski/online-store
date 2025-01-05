package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    private Long orderId;
    private Long date;
    private Long totalCost;
    private Long orderHistoryId;

    @ManyToOne
    private OrderHistory orderHistory;

    @OneToOne
    private Delivery delivery;


}
