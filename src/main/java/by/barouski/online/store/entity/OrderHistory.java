package by.barouski.online.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "order_history")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_history_id")
    private Long orderHistoryId;

    @OneToMany(mappedBy = "orderHistory")
    private List<Ordering> orderingList;

    @OneToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyer;
}
