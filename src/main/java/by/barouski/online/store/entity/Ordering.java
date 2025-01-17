package by.barouski.online.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order")
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "orderId")
    private Long orderId;
    @Column(name= "order_date")
    private LocalDateTime order_date;
    @Column(name= "totalCost")
    private Long totalCost;
    @Column(name= "orderHistoryId")
    private Long orderHistoryId;

    @ManyToOne
    private OrderHistory orderHistory;

    @OneToOne
    private Delivery delivery;


}
