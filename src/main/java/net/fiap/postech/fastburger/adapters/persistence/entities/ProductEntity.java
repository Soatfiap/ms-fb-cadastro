package net.fiap.postech.fastburger.adapters.persistence.entities;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.fiap.postech.fastburger.application.domain.enums.CategoryEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class ProductEntity {

    @Id
    @Field("_id")
    private String id;

    @Indexed(unique = true)
    @Field("SKU")
    private Long sku;

    private String name;


    @Field("category")
    private CategoryEnum categoryEnum;
    private Double price;
    private String description;

    @Field("images")
    private List<ProductImageEntity> images;
}
