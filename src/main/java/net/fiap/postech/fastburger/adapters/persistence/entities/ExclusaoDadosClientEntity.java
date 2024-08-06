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
@Document(collection = "solicitacao_delecao_dados_clients_lgpd")
public class ExclusaoDadosClientEntity {

    @Id
    @Field("_id")
    private String id;

    @Field("nome")
    private String nome;

    @Indexed(unique = true)
    @Field("endereco")
    private String endereco;

    @Indexed(unique = true)
    @Field("telefone")
    private String telefone;
}
