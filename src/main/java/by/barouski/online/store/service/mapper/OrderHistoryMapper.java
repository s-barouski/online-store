package by.barouski.online.store.service.mapper;


import by.barouski.online.store.entity.OrderHistory;

import by.barouski.online.store.service.dto.OrderHistoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses={OrderHistoryMapper.class, AuthorityMapper.class})
public interface OrderHistoryMapper {
    List<OrderHistory> orderHistoryDtosToOrderHistories(List<OrderHistoryDto> orderHistoryDtos);
    List<OrderHistoryDto> orderHistoriesToOrderHistoryDtos(List<OrderHistory> orderHistories);
}
