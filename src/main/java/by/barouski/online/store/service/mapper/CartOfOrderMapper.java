package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.CartOfOrder;
import by.barouski.online.store.service.dto.BuyerDto;
import by.barouski.online.store.service.dto.CartOfOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses={ProductMapper.class, BuyerMapper.class})
public interface CartOfOrderMapper {
    List<CartOfOrder> cartOfOrderDtosToCartOfOrders(List<CartOfOrderDto> cartOfOrderDtos);
    CartOfOrder cartOfOrderDtoToCartOfOrder (CartOfOrderDto cartOfOrderDto);

    List<CartOfOrderDto> cartOfOrdersToCartOfOrderDtos(List<CartOfOrder> cartOfOrders);

    CartOfOrderDto cartOfOrderToCartOfOrderDto (CartOfOrder cartOfOrder);

}
