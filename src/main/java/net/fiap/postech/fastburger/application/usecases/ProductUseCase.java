package net.fiap.postech.fastburger.application.usecases;

import java.util.List;

import net.fiap.postech.fastburger.adapters.configuration.exceptionHandler.BusinessException;
import net.fiap.postech.fastburger.adapters.configuration.exceptionHandler.ProductNotFoundException;
import net.fiap.postech.fastburger.application.domain.Product;
import net.fiap.postech.fastburger.application.domain.enums.CategoryEnum;
import net.fiap.postech.fastburger.application.ports.inputports.product.*;
import net.fiap.postech.fastburger.application.ports.outputports.product.*;

public class ProductUseCase implements SaveProductGateway, UpdateProductGateway, DeleteProductGateway,
        FindProductByCategoryGateway, FindProductByIdGateway {

    private final SaveProductOutPutPort saveProduct;
    private final UpdateProductOutPutPort updateProduct;
    private final DeleteProductOutPutPort deleteProduct;
    private final FindProductByCategoryOutPutPort findProductByCategory;
    private final FindProductByIdOutPutPort findProductById;

    public ProductUseCase(SaveProductOutPutPort saveProduct, UpdateProductOutPutPort updateProduct, DeleteProductOutPutPort deleteProduct,
                          FindProductByCategoryOutPutPort findProductByCategory, FindProductByIdOutPutPort findProductById) {
        this.saveProduct = saveProduct;
        this.updateProduct = updateProduct;
        this.deleteProduct = deleteProduct;
        this.findProductByCategory = findProductByCategory;
        this.findProductById = findProductById;
    }

    @Override
    public Void delete(String id) {
        return this.deleteProduct.delete(id);
    }

    @Override
    public Product save(Product product) {
        if (product.getPrice() <= 0) {
            throw new BusinessException("O valor do produto não pode ser igual ou menor que zero!");
        }
        return this.saveProduct.save(product);
    }

    @Override
    public Product update(String id, Product product) {
        if (product.getPrice() <= 0) {
            throw new BusinessException("O valor do produto não pode ser igual ou menor que zero!");
        }
        return this.updateProduct.update(id, product);
    }

    @Override
    public List<Product> find(CategoryEnum categoryEnum) {
        List<Product> products = this.findProductByCategory.find(categoryEnum);
        if (products.isEmpty())
            throw new ProductNotFoundException("Não foram encontrados produtos para esta categoria");
        return products;
    }

    @Override
    public Product find(String id) {
        Product product = this.findProductById.find(id);
        if (product == null)
            throw new ProductNotFoundException("Não foram encontrados produtos para este id");
        return product;
    }
}
