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
    @Column(name = "order_history_id")
    private Long orderHistoryId;


    @OneToMany(mappedBy = "orderHistory")
    private List<Ordering> orderingList;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id")
//    private List<Ordering> orderings;

    @OneToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id")
    private Buyer buyer;
}
