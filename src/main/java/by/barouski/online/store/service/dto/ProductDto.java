package by.barouski.online.store.service.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long productId;

    private String name;

    private String description;

    private Long price;

    private int quantity;
}
