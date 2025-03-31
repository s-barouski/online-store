package by.barouski.online.store.ctrl;

import by.barouski.online.store.service.BuyerService;
import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.service.dto.BuyerDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping
    public void postBuyer(@RequestBody Buyer buyer) {
        buyerService.createBuyer(buyer);
    }

    @GetMapping
    List<BuyerDto> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    @PutMapping
    void putBuyer(@RequestBody Buyer buyer) {
        buyerService.updateBuyer(buyer);
    }

    @DeleteMapping
    void deleteBuyer(@RequestParam Long id) {
        buyerService.deleteBuyer(id);
    }
}

