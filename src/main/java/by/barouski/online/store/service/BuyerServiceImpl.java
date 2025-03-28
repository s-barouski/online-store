package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.CartOfOrder;
import by.barouski.online.store.entity.OrderHistory;
import by.barouski.online.store.repo.BuyerRepository;
import by.barouski.online.store.repo.CartOfOrdersRepository;
import by.barouski.online.store.repo.OrderHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final OrderHistoryRepository orderHistoryRepository;
    private final CartOfOrdersRepository cartOfOrdersRepository;



    public BuyerServiceImpl(BuyerRepository buyerRepository, OrderHistoryRepository orderHistoryRepository, CartOfOrdersRepository cartOfOrdersRepository) {
        this.buyerRepository = buyerRepository;
        this.orderHistoryRepository = orderHistoryRepository;
        this.cartOfOrdersRepository = cartOfOrdersRepository;
    }


    @Override
    public void createBuyer(Buyer buyer) {
        OrderHistory orderHistory = new OrderHistory();
        buyer.setOrderHistory(orderHistory);
        CartOfOrder cart = new CartOfOrder();
        buyer.setCartOfOrder(cart);
        Buyer buyerToSave = buyerRepository.save(buyer);
       orderHistory.setBuyer(buyerToSave);
        orderHistoryRepository.save(orderHistory);
        cart.setBuyer(buyerToSave);
        cartOfOrdersRepository.save(cart);
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
