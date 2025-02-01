package by.barouski.online.store.service.mapper;


import by.barouski.online.store.entity.OrderHistory;

import by.barouski.online.store.service.dto.OrderHistoryDto;
import by.barouski.online.store.service.dto.OrderingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses={OrderingMapper.class})
public interface OrderHistoryMapper {
    List<OrderHistory> orderHistoryDtosToOrderHistories(List<OrderHistoryDto> orderHistoryDtos);
    OrderHistory orderHistoryDtoToOrderHistory (OrderHistoryDto orderHistoryDto);

    List<OrderHistoryDto> orderHistoriesToOrderHistoryDtos(List<OrderHistory> orderHistories);
    OrderHistoryDto orderHistoryToOrderHistoryDto (OrderHistory orderHistory);
}
