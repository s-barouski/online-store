package by.barouski.online.store.service.dto;

import by.barouski.online.store.entity.Delivery;
import by.barouski.online.store.entity.OrderHistory;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class OrderDTO {
    private Long orderId;

    private Date order_date;

    private Float totalCost;

    private DeliveryDTO delivery;
}
