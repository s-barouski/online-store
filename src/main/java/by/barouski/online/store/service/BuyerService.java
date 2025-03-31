package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.service.dto.BuyerDto;

import java.util.List;

public interface BuyerService {
    void createBuyer(Buyer buyer);

    List<BuyerDto> getAllBuyers();


    void updateBuyer(Buyer buyer);

    void deleteBuyer(Long id);

}
