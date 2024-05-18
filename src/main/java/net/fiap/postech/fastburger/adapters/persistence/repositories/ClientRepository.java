package net.fiap.postech.fastburger.adapters.persistence.repositories;

import net.fiap.postech.fastburger.adapters.persistence.entities.ClientEntity;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;


public interface ClientRepository extends MongoRepository<ClientEntity, String> {
    Optional<ClientEntity> findClientEntityByCpf(String cpf);
}
