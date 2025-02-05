package by.barouski.online.store.service;

import by.barouski.online.store.entity.Buyer;
import by.barouski.online.store.entity.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);

    List<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct (Long id);

}
