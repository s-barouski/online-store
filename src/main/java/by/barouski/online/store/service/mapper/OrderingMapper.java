package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Ordering;
import by.barouski.online.store.service.dto.OrderingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses={OrderHistoryMapper.class, DeliveryMapper.class})
public interface OrderingMapper {
    List<Ordering> orderingDtosToOrderings(List<OrderingDto> orderingDtos);
    Ordering orderingDtoToOrdering(OrderingDto orderingDto);

    List<OrderingDto> orderingsToOrderingDtos(List<Ordering> orderings);
    OrderingDto orderingToOrderingDto(Ordering ordering);
}
