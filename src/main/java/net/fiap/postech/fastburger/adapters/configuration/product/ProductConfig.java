package net.fiap.postech.fastburger.adapters.configuration.product;

import net.fiap.postech.fastburger.application.ports.outputports.product.*;
import net.fiap.postech.fastburger.application.usecases.ProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    public ProductUseCase productUseCase(SaveProductOutPutPort saveProduct,
                                         UpdateProductOutPutPort updateProduct,
                                         DeleteProductOutPutPort deleteProduct,
                                         FindProductByCategoryOutPutPort findProductByCategory,
                                         FindProductByIdOutPutPort findProductById
    ) {
        return new ProductUseCase(saveProduct, updateProduct, deleteProduct, findProductByCategory, findProductById);
    }
}
