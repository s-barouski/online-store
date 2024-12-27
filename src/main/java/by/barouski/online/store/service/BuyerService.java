package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;

import java.util.List;

public interface BuyerService {
    void createBuyer(List<Buyer> buyers);

    List<Buyer> getAllBuyers();
}
