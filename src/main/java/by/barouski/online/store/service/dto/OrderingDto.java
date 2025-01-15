package by.barouski.online.store.service.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class OrderingDto {
    private Long orderId;

    private LocalDateTime order_date;

    private Long totalCost;

    private Long orderHistoryId;
}
