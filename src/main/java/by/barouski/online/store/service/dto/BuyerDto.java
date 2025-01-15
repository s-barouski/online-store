package by.barouski.online.store.service.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerDto {
    private Long buyerId;

    private String firstName;

    private String lastName;

    private Long phoneNumber;

    private String email;
}
