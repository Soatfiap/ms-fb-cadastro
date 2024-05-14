package net.fiap.postech.fastburger.adapters.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.fiap.postech.fastburger.adapters.persistence.mapper.ProductMapper;
import net.fiap.postech.fastburger.adapters.persistence.repositories.ProductRepository;
import net.fiap.postech.fastburger.application.domain.Product;
import net.fiap.postech.fastburger.application.domain.enums.CategoryEnum;
import net.fiap.postech.fastburger.application.ports.outputports.product.FindProductByCategoryOutPutPort;

@Component
public class FindProductByCategoryAdapter implements FindProductByCategoryOutPutPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public FindProductByCategoryAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> find(CategoryEnum categoryEnum) {
        var productEntityList = this.productRepository.findProductEntityByCategoryEnum(categoryEnum);
        List<Product> products = new ArrayList<>();
        productEntityList.forEach(productEntity -> products.add(this.productMapper.toDomain(productEntity)));
        return products;
    }
}
