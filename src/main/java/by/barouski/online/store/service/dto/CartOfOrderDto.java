package by.barouski.online.store.service.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartOfOrderDto {
    private Long cartId;

    private int quantityOfGoods;

    private float totalCost;
}
