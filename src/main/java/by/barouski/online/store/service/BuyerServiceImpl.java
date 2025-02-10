package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.repo.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;


    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;

    }


    @Override
    public void createBuyer(Buyer buyer) {
        buyerRepository.save(buyer);

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
