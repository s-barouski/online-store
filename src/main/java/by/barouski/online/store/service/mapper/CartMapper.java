package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.CartOfOrder;

import by.barouski.online.store.service.dto.CartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CartMapper {
    @Mapping(target = "products", source = "products")
    CartDTO toDTO(CartOfOrder cartOfOrder);

}
