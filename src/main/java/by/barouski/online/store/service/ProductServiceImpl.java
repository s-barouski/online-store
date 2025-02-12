package by.barouski.online.store.service;

import by.barouski.online.store.entity.Image;
import by.barouski.online.store.entity.Product;
import by.barouski.online.store.repo.ImageRepository;
import by.barouski.online.store.repo.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Value("${directory}")
    private String directory;

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void uploadPicture(MultipartFile picture, Product product) {
        try {
            String path = "";
            if (picture != null) {
                path = directory + UUID.nameUUIDFromBytes(picture.getBytes());
                picture.transferTo(Path.of(path));
            }
            product.setImagePath(path);
            productRepository.save(product);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }

    }

    @Override
    public Resource getPicture(Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        String path = product.getImagePath();
        return new FileSystemResource(Path.of(path));
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product product) {
productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    @Transactional(rollbackFor = {SQLException.class, IOException.class},
            isolation = Isolation.READ_COMMITTED)
    public void putPicture(MultipartFile picture, Long id) throws IOException {
        Image image = new Image();
        image.setId(UUID.nameUUIDFromBytes(picture.getBytes()));
        image.setContentType(picture.getContentType());
        image.setDescription(picture.getResource().getDescription());
        image.setOriginalName(picture.getOriginalFilename());
        image.setPathToFile(directory+image.getId());

        Product product = new Product();
        product.setProductId(id);
        image.setProduct(product);

        imageRepository.save(image);
        picture.transferTo(Path.of(image.getPathToFile()));

    }
}
