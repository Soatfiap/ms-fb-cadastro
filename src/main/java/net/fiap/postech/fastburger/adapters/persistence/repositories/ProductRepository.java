package net.fiap.postech.fastburger.adapters.persistence.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import net.fiap.postech.fastburger.adapters.persistence.entities.ProductEntity;
import net.fiap.postech.fastburger.application.domain.enums.CategoryEnum;


public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    List<ProductEntity> findProductEntityByCategoryEnum(CategoryEnum categoryEnum);
    void deleteBySku(String sku);
    Optional<ProductEntity> findBySku(String sku);
}
