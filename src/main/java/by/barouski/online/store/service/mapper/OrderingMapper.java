package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Ordering;
import by.barouski.online.store.service.dto.OrderingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderingMapper {
    List<Ordering> orderingDtosToOrderings(List<OrderingDto> orderingDtos);
    List<OrderingDto> orderingsToOrderingDtos(List<Ordering> orderings);
}
