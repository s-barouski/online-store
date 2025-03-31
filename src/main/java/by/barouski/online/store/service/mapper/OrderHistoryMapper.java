package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.OrderHistory;
import by.barouski.online.store.service.dto.OrderHistoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface OrderHistoryMapper {
    OrderHistoryDTO toDTO (OrderHistory orderHistory);
}
