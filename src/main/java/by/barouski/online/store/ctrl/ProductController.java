package by.barouski.online.store.ctrl;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.Product;
import by.barouski.online.store.service.ProductService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean uploadPicture(@RequestPart(value = "picture", required = false) MultipartFile picture,
                                 @RequestPart(value = "product") Product product) throws IOException {
        productService.uploadPicture(picture, product);
        return Boolean.TRUE;
    }

    @GetMapping(path = "/download/{id}")
    public Resource getPicture(@PathVariable Long id) {
        return productService.getPicture(id);
    }
    @PostMapping
    public void postProduct(@RequestBody Product product) {

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
