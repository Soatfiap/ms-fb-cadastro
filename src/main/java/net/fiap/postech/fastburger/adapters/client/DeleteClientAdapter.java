package net.fiap.postech.fastburger.adapters.client;

import net.fiap.postech.fastburger.adapters.persistence.entities.ClientEntity;
import net.fiap.postech.fastburger.adapters.persistence.repositories.ClientRepository;
import net.fiap.postech.fastburger.application.domain.Client;
import net.fiap.postech.fastburger.application.ports.outputports.client.DeleteClientOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteClientAdapter implements DeleteClientOutPutPort {
    private final ClientRepository clientRepository;

    @Autowired
    public DeleteClientAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public void delete(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(client.getId());
        clientEntity.setCpf(client.getCpf());
        clientEntity.setNome(client.getNome());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setAtivo(false);
        this.clientRepository.save(clientEntity);
    }
}
