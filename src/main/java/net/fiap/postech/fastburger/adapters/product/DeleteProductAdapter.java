package net.fiap.postech.fastburger.adapters.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.fiap.postech.fastburger.adapters.configuration.exceptionHandler.ProductNotFoundException;
import net.fiap.postech.fastburger.adapters.persistence.repositories.ProductRepository;
import net.fiap.postech.fastburger.application.ports.outputports.product.DeleteProductOutPutPort;

@Component
public class DeleteProductAdapter implements DeleteProductOutPutPort {
    private final ProductRepository productRepository;

    @Autowired
    public DeleteProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Void delete(String sku) {
        var prodcutToDelete = this.productRepository.findBySku(Long.parseLong(sku));
        if (!prodcutToDelete.isPresent())
            throw new ProductNotFoundException("Produto não encontrado.");
        this.productRepository.deleteBySku(Long.parseLong(sku));
        return null;
    }
}
