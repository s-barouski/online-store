package by.barouski.online.store.service;

import by.barouski.online.store.entity.DeliveryType;
import by.barouski.online.store.entity.Product;
import by.barouski.online.store.service.dto.ProductDto;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ProductService {

    //void uploadPicture(MultipartFile picture, ProductDto productDto);

    Resource getPicture(UUID id);

    void createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct (Long id);

    void putPicture(MultipartFile picture, Long id) throws IOException;


    void addToCart(Long productId, Long cartOfOrderId);

    void buyAllProducts(Long cartOfOrderId, String address, DeliveryType deliveryType );

    void buyOneProduct(Long productId, Long cartOfOrderId, String address, DeliveryType deliveryType );

}
