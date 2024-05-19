package net.fiap.postech.fastburger.application.usecases;

import net.fiap.postech.fastburger.application.domain.Product;
import net.fiap.postech.fastburger.application.domain.enums.CategoryEnum;
import net.fiap.postech.fastburger.application.ports.outputports.product.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductUseCaseTest {

    private SaveProductOutPutPort saveProductOutPutPort;
    private UpdateProductOutPutPort updateProductOutPutPort;
    private DeleteProductOutPutPort deleteProductOutPutPort;
    private FindProductByCategoryOutPutPort findProductByCategoryOutPutPort;
    private FindProductByIdOutPutPort findProductByIdOutPutPort;
    private ProductUseCase productUseCase;

    @BeforeEach
    void setUp() {
        saveProductOutPutPort = Mockito.mock(SaveProductOutPutPort.class);
        updateProductOutPutPort = Mockito.mock(UpdateProductOutPutPort.class);
        deleteProductOutPutPort = Mockito.mock(DeleteProductOutPutPort.class);
        findProductByCategoryOutPutPort = Mockito.mock(FindProductByCategoryOutPutPort.class);
        findProductByIdOutPutPort = Mockito.mock(FindProductByIdOutPutPort.class);

        productUseCase = new ProductUseCase(saveProductOutPutPort, updateProductOutPutPort, deleteProductOutPutPort,
                findProductByCategoryOutPutPort, findProductByIdOutPutPort);
    }

    @Test
    void delete() {
        String id = "1";
        productUseCase.delete(id);
        verify(deleteProductOutPutPort, times(1)).delete(id);
    }

    @Test
    void save() {
        Product product = new Product();
        product.setPrice(10.0);
        when(saveProductOutPutPort.save(any(Product.class))).thenReturn(product);
        Product savedProduct = productUseCase.save(product);
        assertEquals(product, savedProduct);
    }

    @Test
    void update() {
        String id = "1";
        Product product = new Product();
        product.setPrice(10.0);
        when(updateProductOutPutPort.update(anyString(), any(Product.class))).thenReturn(product);
        Product updatedProduct = productUseCase.update(id, product);
        assertEquals(product, updatedProduct);
    }

    @Test
    void find() {
        CategoryEnum categoryEnum = CategoryEnum.BURGERS;
        Product product = new Product();
        when(findProductByCategoryOutPutPort.find(any(CategoryEnum.class))).thenReturn(Collections.singletonList(product));
        List<Product> products = productUseCase.find(categoryEnum);
        assertFalse(products.isEmpty());
    }

    @Test
    void FindById() {
        String id = "1";
        Product product = new Product();
        when(findProductByIdOutPutPort.find(anyString())).thenReturn(product);
        Product foundProduct = productUseCase.find(id);
        assertEquals(product, foundProduct);
    }
}