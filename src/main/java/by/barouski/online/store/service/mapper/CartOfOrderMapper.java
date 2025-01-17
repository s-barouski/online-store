package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.CartOfOrder;
import by.barouski.online.store.service.dto.BuyerDto;
import by.barouski.online.store.service.dto.CartOfOrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses={OrderHistoryMapper.class, AuthorityMapper.class})
public interface CartOfOrderMapper {
    List<CartOfOrder> cartOfOrderDtosToCartOfOrders(List<CartOfOrderDto> cartOfOrderDtos);
    List<CartOfOrderDto> cartOfOrdersToCartOfOrderDtos(List<CartOfOrder> cartOfOrders);

}
