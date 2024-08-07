package net.fiap.postech.fastburger.adapters.persistence.repositories;

import net.fiap.postech.fastburger.adapters.persistence.entities.ExclusaoDadosClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface DelecaoDadosClientRepository extends MongoRepository<ExclusaoDadosClientEntity, String> {
    Optional<ExclusaoDadosClientEntity> findExclusaoDadosClientEntitiesByNome(String nome);
}
