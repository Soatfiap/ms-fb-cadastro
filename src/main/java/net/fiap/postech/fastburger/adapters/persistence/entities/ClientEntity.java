package net.fiap.postech.fastburger.adapters.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")

public class ClientEntity {

    @Id
    @Field("_id")
    private String id;

    @Indexed(unique = true)
    @Field("cpf")
    private String cpf;

    @Field("nome")
    private String nome;

    @Indexed(unique = true)
    @Field("email")
    private String email;
}
