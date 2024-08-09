package net.fiap.postech.fastburger.application.ports.inputports.client;

import net.fiap.postech.fastburger.application.domain.Client;

public interface DeleteClientGateway {
    void delete(Client client);
}
