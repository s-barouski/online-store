package by.barouski.online.store.service.dto;

import by.barouski.online.store.entity.DeliveryType;
import by.barouski.online.store.entity.Ordering;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class DeliveryDTO {
    private Long deliveryId;

    private Date delivery_date;

    private DeliveryType deliveryType;

    private Long deliveryCost;

    private String address;

}
