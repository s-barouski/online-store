package by.barouski.online.store.service.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class DeliveryDto {
    private Long deliveryId;

    private LocalDateTime delivery_date;

    private String deliveryType;

    private Long deliveryCost;

    private String address;
}
