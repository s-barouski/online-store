package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;

import java.util.List;

public interface BuyerService {
    void createBuyer(Buyer buyer);

    List<Buyer> getAllBuyers();

    void updateBuyer(Buyer buyer);

    void deleteBuyer(Long id);

}
