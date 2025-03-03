package by.barouski.online.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ordering")
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "order_id")
    private Long orderId;
    @Column(name= "order_date")
    private Date order_date;
    @Column(name= "totalCost")
    private Long totalCost;

    @ManyToOne
    @JoinColumn(name = "order_history_id", nullable = false)
    private OrderHistory orderHistory;

    @OneToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id")
    private Delivery delivery;



}
