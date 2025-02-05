package by.barouski.online.store.ctrl;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.Product;
import by.barouski.online.store.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void postBuyer(@RequestBody Product product) {

        productService.createProduct(product);
    }

    @GetMapping
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PutMapping
    void putProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
    @DeleteMapping
    void deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
    }
}
