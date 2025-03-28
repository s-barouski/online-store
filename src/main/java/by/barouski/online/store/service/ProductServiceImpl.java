package by.barouski.online.store.service;

import by.barouski.online.store.entity.*;
import by.barouski.online.store.repo.*;
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
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

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
    private final DeliveryService deliveryService;

    public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository, ProductMapper productMapper, CartOfOrdersRepository cartOfOrdersRepository, OrderRepository orderRepository, DeliveryService deliveryService) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.productMapper = productMapper;
        this.cartOfOrdersRepository = cartOfOrdersRepository;
        this.orderRepository = orderRepository;
        this.deliveryService = deliveryService;
    }

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
            isolation = Isolation.SERIALIZABLE)
    public void putPicture(MultipartFile picture, Long id) throws IOException {
        Image image = new Image();
        image.setContentType(picture.getContentType());
        image.setDescription(picture.getResource().getDescription());
        image.setOriginalName(picture.getOriginalFilename());
        image.setPathToFile(directory + picture.getOriginalFilename());
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
        cartOfOrder.setTotalCost(cartOfOrder.getTotalCost() + product.getPrice());
        cartOfOrder.setQuantityOfGoods(cartOfOrder.getQuantityOfGoods() + 1);
        cartOfOrdersRepository.save(cartOfOrder);
    }


    @Override
    public void buyAllProducts(Long cartOfOrderId, String address, DeliveryType deliveryType) {
        CartOfOrder cartOfOrder = cartOfOrdersRepository.findById(cartOfOrderId).get();
        Ordering order = new Ordering();
        order.setTotalCost(cartOfOrder.getTotalCost());
        order.setOrder_date(new Date(new java.util.Date().getTime()));
        order.setOrderHistory(cartOfOrder.getBuyer().getOrderHistory());
        List<Product> products = cartOfOrder.getProducts();
        products.forEach((product) -> product.setQuantity(product.getQuantity() - 1));
        productRepository.saveAll(products);
        Delivery delivery = deliveryService.createDelivery(deliveryType, address);
        order.setDelivery(delivery);
        orderRepository.save(order);
        cartOfOrder.setProducts(List.of());
        cartOfOrdersRepository.save(cartOfOrder);
    }

    public void buyOneProduct(Long productId, Long cartOfOrderId, String address, DeliveryType deliveryType) {
        CartOfOrder cartOfOrder = cartOfOrdersRepository.findById(cartOfOrderId).get();
        Ordering order = new Ordering();
        Product oneProduct = new Product();
        for (Product product : cartOfOrder.getProducts()) {
            if (Objects.equals(productId, product.getProductId())) {
                oneProduct = product;
                break;
            }
        }
        //        oneProduct =cartOfOrder.getProducts().stream()
//                .filter(p -> Objects.equals(p.getProductId(), productId)).findFirst().get();

        order.setTotalCost(oneProduct.getPrice());
       // order.setOrder_date(new Date());
        order.setOrderHistory(cartOfOrder.getBuyer().getOrderHistory());
        Delivery delivery = deliveryService.createDelivery(deliveryType, address);
        order.setDelivery(delivery);
        orderRepository.save(order);
        cartOfOrder.getProducts().remove(oneProduct);
    }


}
