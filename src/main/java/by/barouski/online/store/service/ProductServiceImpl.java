package by.barouski.online.store.service;

import by.barouski.online.store.entity.*;
import by.barouski.online.store.repo.CartOfOrdersRepository;
import by.barouski.online.store.repo.ImageRepository;
import by.barouski.online.store.repo.OrderRepository;
import by.barouski.online.store.repo.ProductRepository;
import by.barouski.online.store.service.dto.ProductDto;
import by.barouski.online.store.service.mapper.ProductMapper;
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
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Value("${directory}")
    private String directory;

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;
    private final ProductMapper productMapper;
    private final CartOfOrdersRepository cartOfOrdersRepository;
    private final OrderRepository orderRepository;

    public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository, ProductMapper productMapper, CartOfOrdersRepository cartOfOrdersRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.productMapper = productMapper;
        this.cartOfOrdersRepository = cartOfOrdersRepository;
        this.orderRepository = orderRepository;
    }

//    @Override
//    public void uploadPicture(MultipartFile picture, ProductDto productDto) {
//        try {
//            String path = "";
//            if (picture != null) {
//                path = directory + UUID.nameUUIDFromBytes(picture.getBytes());
//                picture.transferTo(Path.of(path));
//            }
//            Product product = productMapper.productDtoToProduct(productDto);
//            product.setImagePath(path);
//            productRepository.save(product);
//        } catch (IOException e) {
//            log.error(e.getLocalizedMessage());
//        }
//
//    }

    @Override
    public Resource getPicture(UUID id) {
        Image image = imageRepository.findById(id).orElseThrow(RuntimeException::new);
        String path = image.getPathToFile();
        return new FileSystemResource(Path.of(path));
    }

    @Override
    public void createProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos;
        List<Product> products;
        products = productRepository.findAll();
        productDtos = productMapper.productsToProductDtos(products);
        return productDtos;
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
        image.setPathToFile(directory + image.getId());

        Product product = new Product();
        product.setProductId(id);
        image.setProduct(product);

        imageRepository.save(image);
        picture.transferTo(Path.of(image.getPathToFile()));
    }

    @Override
    @Transactional
    public void addToCart(Long productId, Long cartOfOrderId) {
        CartOfOrder cartOfOrder = cartOfOrdersRepository.findById(cartOfOrderId).get();
        List<Product> products = cartOfOrder.getProducts();
        Product product = productRepository.findById(productId).get();
        products.add(product);
        cartOfOrder.setProducts(products);
        cartOfOrder.setTotalCost(cartOfOrder.getTotalCost()+product.getPrice());
        cartOfOrder.setQuantityOfGoods(cartOfOrder.getQuantityOfGoods()+1);
        cartOfOrdersRepository.save(cartOfOrder);

        }

    @Override
    public void buyAllProducts(Long cartOfOrderId, String adress, DeliveryType deliveryType ) {
        CartOfOrder cartOfOrder = cartOfOrdersRepository.findById(cartOfOrderId).get();
        Ordering order = new Ordering();
        order.setTotalCost(cartOfOrder.getTotalCost());
        order.setOrder_date(Date.from(Instant.now()));
        order.setOrderHistory(cartOfOrder.getBuyer().getOrderHistory());
        Delivery delivery = new Delivery();
        delivery.setDelivery_date(Date.from(Instant.now().plus(Duration.ofDays(3))));
        delivery.setDeliveryCost(0L);
        delivery.setDeliveryType(deliveryType);// сделать энам
        delivery.setAddress(adress);
        order.setDelivery(delivery);
        orderRepository.save(order);

    }


}
