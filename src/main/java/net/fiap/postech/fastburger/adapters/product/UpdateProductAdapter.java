package net.fiap.postech.fastburger.adapters.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.fiap.postech.fastburger.adapters.persistence.mapper.ProductMapper;
import net.fiap.postech.fastburger.adapters.persistence.repositories.ProductRepository;
import net.fiap.postech.fastburger.application.domain.Product;
import net.fiap.postech.fastburger.application.ports.outputports.product.UpdateProductOutPutPort;

@Component
public class UpdateProductAdapter implements UpdateProductOutPutPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public UpdateProductAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product update(String sku, Product product) {

        var productEntity = this.productRepository.findById(Long.parseLong(sku));
        var productEntityToSave = this.productMapper.domainToEntity(product);
        productEntityToSave.setSKU(productEntity.get().getSKU());
        return this.productMapper.toDomain(this.productRepository.save(productEntityToSave));
    }
}
