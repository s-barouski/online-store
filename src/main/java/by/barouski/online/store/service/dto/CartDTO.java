package by.barouski.online.store.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CartDTO {
    private Long Id;
    private int quantityOfGoods;
    private Float totalCost = 0F;
    private List<ProductDto> products;
}
