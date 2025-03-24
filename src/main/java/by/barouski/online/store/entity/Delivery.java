package by.barouski.online.store.entity;

import jakarta.persistence.*;
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
@Table (name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long deliveryId;
    @Column(name = "delivery_date")
    private Date delivery_date;
    @Column(name = "deliveryType")
    private DeliveryType deliveryType;//enum
    @Column(name = "deliveryCost")
    private Long deliveryCost; // везде большой лонг
    @Column(name = "address")
    private String address;


    @OneToOne(mappedBy = "delivery")
    private Ordering ordering;
}
