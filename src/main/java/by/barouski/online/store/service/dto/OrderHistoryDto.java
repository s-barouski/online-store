package by.barouski.online.store.service.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderHistoryDto {
    private Long orderHistoryId;

    private Long buyerId;
}
