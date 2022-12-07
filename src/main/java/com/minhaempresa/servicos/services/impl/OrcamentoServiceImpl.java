package com.minhaempresa.servicos.services.impl;

import com.minhaempresa.servicos.adapter.OrcamentoAdapter;
import com.minhaempresa.servicos.bd.entities.ClienteEntity;
import com.minhaempresa.servicos.bd.entities.OrcamentoEntity;
import com.minhaempresa.servicos.dto.OrcamentoDTO;
import com.minhaempresa.servicos.exception.ClienteAlreadyRegistredException;
import com.minhaempresa.servicos.exception.OrcamentoAlreadyRegistredException;
import com.minhaempresa.servicos.exception.OrcamentoNotFoundException;
import com.minhaempresa.servicos.repository.OrcamentoRepository;
import com.minhaempresa.servicos.services.OrcamentoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class OrcamentoServiceImpl implements OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;

    @Autowired
    public OrcamentoServiceImpl(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    @Override
    public OrcamentoDTO createOrcamento(OrcamentoDTO orcamentoDTO) throws OrcamentoAlreadyRegistredException {
        verifyIfIsAlreadyRegistred(orcamentoDTO.getModelo());
        OrcamentoEntity orcamento = new OrcamentoAdapter(orcamentoDTO).getOrcamentoEntity();
        OrcamentoEntity savedOrcamento = orcamentoRepository.save(orcamento);
        return new OrcamentoAdapter(savedOrcamento).getOrcamentoDTO();
    }

    @Override
    public OrcamentoDTO findById(Long id) throws OrcamentoNotFoundException{
        OrcamentoEntity foundOrcamento = verifyIfExists(id);
        return new OrcamentoAdapter(foundOrcamento).getOrcamentoDTO();
    }

    @Override
    public List<OrcamentoDTO> listAll(){
        return new OrcamentoAdapter(orcamentoRepository.findAll()).getOrcamentoDTOList();

    }

    @Override
    public void deleteById(Long id) throws OrcamentoNotFoundException {
        verifyIfExists(id);
        orcamentoRepository.deleteById(id);
    }

    private OrcamentoEntity verifyIfExists(Long id) throws OrcamentoNotFoundException{
        return orcamentoRepository.findById(id)
                .orElseThrow(() -> new OrcamentoNotFoundException(id));
    }

    private void verifyIfIsAlreadyRegistred(String name) throws OrcamentoAlreadyRegistredException {
        Optional<OrcamentoEntity> optSavedBeer = orcamentoRepository.findByModelo(name);
        if(optSavedBeer.isPresent()){
            throw new OrcamentoAlreadyRegistredException(name);
        }
    }
}