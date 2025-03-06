package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.OrderHistory;
import by.barouski.online.store.repo.BuyerRepository;
import by.barouski.online.store.repo.OrderHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final OrderHistoryRepository orderHistoryRepository;



    public BuyerServiceImpl(BuyerRepository buyerRepository, OrderHistoryRepository orderHistoryRepository) {
        this.buyerRepository = buyerRepository;

        this.orderHistoryRepository = orderHistoryRepository;
    }


    @Override
    public void createBuyer(Buyer buyer) {
        Buyer buyerToSave = buyerRepository.save(buyer);
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setBuyer(buyerToSave);
        orderHistoryRepository.save(orderHistory);
    }

    @Override
    public List<Buyer> getAllBuyers() {

        return buyerRepository.findAll();

    }


    @Override
    public void updateBuyer(Buyer buyer) {
buyerRepository.saveAndFlush(buyer);

    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }

}
