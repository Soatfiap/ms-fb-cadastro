package net.fiap.postech.fastburger.application.usecases;

import net.fiap.postech.fastburger.application.domain.Client;
import net.fiap.postech.fastburger.application.ports.inputports.client.DeleteClientGateway;
import net.fiap.postech.fastburger.application.ports.inputports.client.FindClientByCpfGateway;
import net.fiap.postech.fastburger.application.ports.inputports.client.SaveClientGateway;
import net.fiap.postech.fastburger.application.ports.outputports.client.DeleteClientOutPutPort;
import net.fiap.postech.fastburger.application.ports.outputports.client.FindClientByCpfOutPutPort;
import net.fiap.postech.fastburger.application.ports.outputports.client.SaveClientOutPutPort;

public class ClientUseCase implements SaveClientGateway, FindClientByCpfGateway, DeleteClientGateway {
    private final SaveClientOutPutPort saveClientOutPutPort;
    private final DeleteClientOutPutPort deleteClientOutPutPort;
    private final FindClientByCpfOutPutPort findClientByCpfOutPutPort;

    public ClientUseCase(SaveClientOutPutPort saveClientOutPutPort, DeleteClientOutPutPort deleteClientOutPutPort, FindClientByCpfOutPutPort findClientByCpfOutPutPort) {
        this.saveClientOutPutPort = saveClientOutPutPort;
        this.deleteClientOutPutPort = deleteClientOutPutPort;
        this.findClientByCpfOutPutPort = findClientByCpfOutPutPort;
    }

    @Override
    public Client find(String cpf) {
        return this.findClientByCpfOutPutPort.find(cpf);
    }

    @Override
    public Client save(Client client) {
        return this.saveClientOutPutPort.save(client);
    }

    @Override
    public void delete(Client client) {
        this.deleteClientOutPutPort.delete(client);
    }
}
