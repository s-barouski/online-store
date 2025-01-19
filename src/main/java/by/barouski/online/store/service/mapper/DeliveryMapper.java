package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.CartOfOrder;
import by.barouski.online.store.entity.Delivery;
import by.barouski.online.store.service.dto.CartOfOrderDto;
import by.barouski.online.store.service.dto.DeliveryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses={OrderingMapper.class})
public interface DeliveryMapper {
    List<Delivery> deliveryDtosToDeliveries(List<DeliveryDto> deliveryDtos);
    List<DeliveryDto> deliveriesToDeliveryDtos(List<Delivery> deliveries);
}
