package by.barouski.online.store.ctrl;

import by.barouski.online.store.entity.CartOfOrder;
import by.barouski.online.store.entity.DeliveryType;
import by.barouski.online.store.entity.Product;
import by.barouski.online.store.service.ProductService;
import by.barouski.online.store.service.dto.ProductDto;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/download/{id}", produces = IMAGE_JPEG_VALUE)
    public Resource getPicture(@PathVariable UUID id) {
        return productService.getPicture(id);
    }

    @PostMapping
    public void postProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
    }

    @GetMapping
    List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public void putPicture(@RequestPart(value = "picture") MultipartFile picture,
                           @PathVariable Long id) throws IOException {
        productService.putPicture(picture, id);
    }

    @DeleteMapping
    void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/add")
    public void addToCart(@RequestParam Long productId, @RequestParam Long cartOfOrderId) {
        productService.addToCart(productId, cartOfOrderId);
    }

    @PostMapping("/buyall")
    public void buyAllProducts(@RequestParam Long cartOfOrderId, @RequestParam String address, @RequestParam DeliveryType deliveryType) {
        productService.buyAllProducts(cartOfOrderId, address, deliveryType);
    }

    @PostMapping("/buyone")
    public void buyOneProducts( @RequestParam Long productId,@RequestParam Long cartOfOrderId, @RequestParam String address, @RequestParam DeliveryType deliveryType) {
        productService.buyOneProduct(productId, cartOfOrderId, address, deliveryType);
    }
}
