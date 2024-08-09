package net.fiap.postech.fastburger.adapters.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.fiap.postech.fastburger.adapters.client.LGPDServiceDelecaoDados;
import net.fiap.postech.fastburger.adapters.configuration.exceptionHandler.HandlerBodyException;
import net.fiap.postech.fastburger.adapters.persistence.dto.ClientDTO;
import net.fiap.postech.fastburger.adapters.persistence.dto.LGPDClientDeleteDTO;
import net.fiap.postech.fastburger.adapters.persistence.mapper.ClientMapper;
import net.fiap.postech.fastburger.application.domain.Client;
import net.fiap.postech.fastburger.application.ports.inputports.client.DeleteClientGateway;
import net.fiap.postech.fastburger.application.ports.inputports.client.FindClientByCpfGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client/lgpd/exclusao-dados")
@Tag(name = "LGPD Normativa Exclusao de dados Controller Rest")
public class LGPDNormativaController {

    private DeleteClientGateway deleteClientGateway;
    private FindClientByCpfGateway findClientByCpfGateway;
    private LGPDServiceDelecaoDados lgpdServiceDelecaoDados;
    private ClientMapper clientMapper;

    @Autowired
    public LGPDNormativaController(DeleteClientGateway deleteClientGateway, FindClientByCpfGateway findClientByCpfGateway, LGPDServiceDelecaoDados lgpdServiceDelecaoDados, ClientMapper clientMapper) {
        this.deleteClientGateway = deleteClientGateway;
        this.findClientByCpfGateway = findClientByCpfGateway;
        this.lgpdServiceDelecaoDados = lgpdServiceDelecaoDados;
        this.clientMapper = clientMapper;
    }

    @PostMapping("/{cpf}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(description = "Exclui dados de cadastro do Cliente Considerando a LGPD", method = "POST")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Dados deletados com sucesso", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Cliente não estruturado corretamente", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = HandlerBodyException.class))
                    })
            }
    )
    public ResponseEntity save(@RequestBody @Valid LGPDClientDeleteDTO lgpdClientDeleteDTO, @PathVariable String cpf) {
        var clientDTO = this.findClientByCpfGateway.find(cpf);
        this.deleteClientGateway.delete(clientDTO);
        this.lgpdServiceDelecaoDados.registrarSolicitacaoDeDelecaoDeDados(lgpdClientDeleteDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
