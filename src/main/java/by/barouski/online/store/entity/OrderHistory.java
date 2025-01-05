package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

public class OrderHistory {
    @Id
    private Long orderHistoryId;
    private Long buyerId;

    @OneToMany
    private List<Order> orders;
}
