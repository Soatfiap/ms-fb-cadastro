package net.fiap.postech.fastburger.adapters.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product_images")
public class ProductImageEntity {

    @Id
    @Field("_id")
    private String id;

    @Field("url")
    private String url;
}
