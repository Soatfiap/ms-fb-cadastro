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
import org.springframework.data.annotation.Id;

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
    private String sku;

    @Field("name")
    private String name;


    @Field("category")
    private CategoryEnum categoryEnum;

    @Field("price")
    private Double price;
    @Field("description")
    private String description;

    @Field("images")
    private List<ProductImageEntity> images;
}
