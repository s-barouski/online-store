package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Ordering;
import by.barouski.online.store.service.dto.OrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = DeliveryMapper.class)
public interface OrderMapper {
    OrderDTO toDTO (Ordering ordering);
    List<OrderDTO> toDTOList (List<Ordering> orderings);

}
