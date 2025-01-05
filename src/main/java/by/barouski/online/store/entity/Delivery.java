package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Delivery {
    @Id
    private Long deliveryId;
    private LocalDateTime date;
    private String deliveryType;//enum
    private Long deliveryCost; // везде большой лонг
    private String address;

    @OneToOne
    private Order order;
}

