package by.barouski.online.store.service;

import by.barouski.online.store.entity.Product;
import by.barouski.online.store.service.dto.ProductDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    void uploadPicture(MultipartFile picture, ProductDto productDto);

    Resource getPicture(Long id);

    void createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct (Long id);

    void putPicture(MultipartFile picture, Long id) throws IOException;

}
