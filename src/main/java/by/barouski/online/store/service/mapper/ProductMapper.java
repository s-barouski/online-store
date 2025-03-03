package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Image;
import by.barouski.online.store.entity.Product;
import by.barouski.online.store.service.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<Product> productDtosToProducts(List<ProductDto> productDtos);

    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productsToProductDtos(List<Product> products);


    @Mapping(target = "imageIds", source = "imageList")
    ProductDto productToProductDto(Product product);

    default UUID imageListToImageIds(Image image) {

        return image.getId();
    }
}