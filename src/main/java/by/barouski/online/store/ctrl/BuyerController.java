package by.barouski.online.store.ctrl;
import by.barouski.online.store.service.BuyerService;
import by.barouski.online.store.service.BuyerServiceImpl;
import by.barouski.online.store.entity.Buyer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    private final BuyerService buyerService;


    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;

    }

    @PostMapping("/buyer")
    void postBuyer(@RequestBody List<Buyer> buyer) {
        buyerService.createBuyer(buyer);
    }

    @GetMapping
    List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }
}
