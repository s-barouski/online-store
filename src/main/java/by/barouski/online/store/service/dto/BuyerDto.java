package by.barouski.online.store.service.dto;

import by.barouski.online.store.entity.OrderHistory;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyerDto {
    private Long buyerId;

    private String firstName;

    private String lastName;

    private Long phoneNumber;

    private String email;

    private CartDTO cartDTO;

    private OrderHistoryDTO orderHistoryDTO;
}
