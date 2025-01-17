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
    @Column(name = "orderHistoryId")
    private Long orderHistoryId;
    @Column(name = "buyerId")
    private Long buyerId;

    @OneToMany
    private List<Ordering> orderings;
}
