package net.fiap.postech.fastburger.adapters.client;

import net.fiap.postech.fastburger.adapters.persistence.dto.LGPDClientDeleteDTO;
import net.fiap.postech.fastburger.adapters.persistence.entities.ExclusaoDadosClientEntity;
import net.fiap.postech.fastburger.adapters.persistence.repositories.DelecaoDadosClientRepository;
import org.springframework.stereotype.Service;

@Service
public class LGPDServiceDelecaoDados {
    private final DelecaoDadosClientRepository delecaoDadosClientRepository;

    public LGPDServiceDelecaoDados(DelecaoDadosClientRepository delecaoDadosClientRepository) {
        this.delecaoDadosClientRepository = delecaoDadosClientRepository;
    }

    public void registrarSolicitacaoDeDelecaoDeDados(LGPDClientDeleteDTO lgpdClientDeleteDTO) {
        ExclusaoDadosClientEntity exclusaoDadosClientEntity = new ExclusaoDadosClientEntity();
        exclusaoDadosClientEntity.setNome(lgpdClientDeleteDTO.getNome());
        exclusaoDadosClientEntity.setEndereco(lgpdClientDeleteDTO.getEndereco());
        exclusaoDadosClientEntity.setTelefone(lgpdClientDeleteDTO.getTelefone());
        this.delecaoDadosClientRepository.save(exclusaoDadosClientEntity);
    }
}
