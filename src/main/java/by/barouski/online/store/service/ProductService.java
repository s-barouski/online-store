package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.Product;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    void uploadPicture(MultipartFile picture, Product product);

    Resource getPicture(Long id);

    void createProduct(Product product);

    List<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct (Long id);

    void putPicture(MultipartFile picture, Long id) throws IOException;

}
