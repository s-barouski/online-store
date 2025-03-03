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
@Table (name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long deliveryId;
    @Column(name = "delivery_date")
    private Date delivery_date;
    @Column(name = "deliveryType")
    private String deliveryType;//enum
    @Column(name = "deliveryCost")
    private Long deliveryCost; // везде большой лонг
    @Column(name = "address")
    private String address;


    @OneToOne(mappedBy = "delivery")
    private Ordering ordering;
}
