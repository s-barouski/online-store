package by.barouski.online.store.ctrl;

import by.barouski.online.store.entity.CartOfOrder;
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

//    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public Boolean uploadPicture(@RequestPart(value = "picture", required = false) MultipartFile picture,
//                                 @RequestPart(value = "product") ProductDto productDto) throws IOException {
//        productService.uploadPicture(picture, productDto);
//        return Boolean.TRUE;
//    }

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

    @PostMapping("/add/{productId}/to/{cartOfOrderId}")
    public void addToCart(@PathVariable Long productId, @PathVariable Long cartOfOrderId) {
        productService.addToCart(productId, cartOfOrderId);
    }

    @PostMapping("{buy/from/{cartOfOrderId}")
    public void buyAllProducts (@PathVariable Long cartOfOrderId){
        productService.buyAllProducts(cartOfOrderId);
    }
}
