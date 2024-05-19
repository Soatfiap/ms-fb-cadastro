package net.fiap.postech.fastburger.adapters.product;

import net.fiap.postech.fastburger.adapters.persistence.mapper.ProductMapper;
import net.fiap.postech.fastburger.adapters.persistence.repositories.ProductRepository;
import net.fiap.postech.fastburger.application.domain.Product;
import net.fiap.postech.fastburger.application.ports.outputports.product.FindProductByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindProductByIdAdapter implements FindProductByIdOutPutPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public FindProductByIdAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product find(String id) {
        var productEntity = this.productRepository.findById(id.toString());
        return this.productMapper.toDomain(productEntity.orElseThrow(() -> new RuntimeException("Product not found")));
    }
}
