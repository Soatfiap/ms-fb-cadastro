package net.fiap.postech.fastburger.adapters.client;

import net.fiap.postech.fastburger.adapters.configuration.exceptionHandler.ClientNotFoundException;
import net.fiap.postech.fastburger.adapters.persistence.entities.ClientEntity;
import net.fiap.postech.fastburger.adapters.persistence.mapper.ClientMapper;
import net.fiap.postech.fastburger.adapters.persistence.repositories.ClientRepository;
import net.fiap.postech.fastburger.application.domain.Client;
import net.fiap.postech.fastburger.application.ports.inputports.client.FindClientByCpfGateway;
import net.fiap.postech.fastburger.application.ports.outputports.client.FindClientByCpfOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindClientAdapter implements FindClientByCpfOutPutPort {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public FindClientAdapter(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client find(String cpf) {
        Optional<ClientEntity> clientEntity = this.clientRepository.findClientEntityByCpf(cpf).filter(ClientEntity::isAtivo);
        return this.clientMapper.toDomain(clientEntity.orElseThrow(() -> new ClientNotFoundException("Client not found.")));
    }
}
