package net.fiap.postech.fastburger.adapters.persistence.repositories;

import net.fiap.postech.fastburger.adapters.persistence.entities.ClientEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity, String> {
    Optional<ClientEntity> findClientEntityByCpf(String cpf);
    void delete(ClientEntity clientEntity);
}
