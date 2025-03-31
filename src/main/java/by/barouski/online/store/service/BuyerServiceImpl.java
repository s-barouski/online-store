package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.CartOfOrder;
import by.barouski.online.store.entity.OrderHistory;
import by.barouski.online.store.entity.Product;
import by.barouski.online.store.repo.BuyerRepository;
import by.barouski.online.store.repo.CartOfOrdersRepository;
import by.barouski.online.store.repo.OrderHistoryRepository;
import by.barouski.online.store.service.dto.BuyerDto;
import by.barouski.online.store.service.dto.ProductDto;
import by.barouski.online.store.service.mapper.BuyerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final OrderHistoryRepository orderHistoryRepository;
    private final CartOfOrdersRepository cartOfOrdersRepository;
    private final BuyerMapper buyerMapper;


    public BuyerServiceImpl(BuyerRepository buyerRepository, OrderHistoryRepository orderHistoryRepository, CartOfOrdersRepository cartOfOrdersRepository, BuyerMapper buyerMapper) {
        this.buyerRepository = buyerRepository;
        this.orderHistoryRepository = orderHistoryRepository;
        this.cartOfOrdersRepository = cartOfOrdersRepository;
        this.buyerMapper = buyerMapper;
    }


    @Override
    public void createBuyer(Buyer buyer) {

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setBuyer(buyer);
        CartOfOrder cart = new CartOfOrder();
        buyer.setCartOfOrder(cart);
        buyer.setOrderHistory(orderHistory);
        buyerRepository.save(buyer);
    }

    @Override
    public List<BuyerDto> getAllBuyers() {
        List<BuyerDto> buyerDtos;
        List<Buyer> buyers;
        buyers = buyerRepository.findAll();
        buyerDtos = buyerMapper.buyersToBuyerDtos(buyers);
        return buyerDtos;
    }


    @Override
    public void updateBuyer(Buyer buyer) {
        buyerRepository.saveAndFlush(buyer);

    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }

}
