package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Product;
import by.barouski.online.store.service.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<Product> productDtosToProducts(List<ProductDto> productDtos);
    Product productDtoToProduct (ProductDto productDto);

    List<ProductDto> productsToProductDtos(List<Product> products);
    ProductDto productToProductDto(Product product);
}
