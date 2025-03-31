package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Authority;
import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.service.dto.AuthorityDto;
import by.barouski.online.store.service.dto.BuyerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses={AuthorityMapper.class})
public interface BuyerMapper {
    List<Buyer> buyerDtosToBuyers(List<BuyerDto> buyerDtos);
    @Mapping(target = "cartOfOrder", source = "cartDTO")
    @Mapping(target = "orderHistory", source = "orderHistoryDTO")
    Buyer buyerDtoToBuyer (BuyerDto buyerDto);

    List<BuyerDto> buyersToBuyerDtos(List<Buyer> buyers);
    @Mapping(target = "cartDTO", source = "cartOfOrder")
    @Mapping(target = "orderHistoryDTO", source = "orderHistory")
    BuyerDto buyerToBuyerDto(Buyer buyer);

}
