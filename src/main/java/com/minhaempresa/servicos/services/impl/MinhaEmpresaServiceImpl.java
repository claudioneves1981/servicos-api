package com.minhaempresa.servicos.services.impl;

import com.minhaempresa.servicos.bd.entities.MinhaEmpresaEntity;
import com.minhaempresa.servicos.dto.MinhaEmpresaDTO;
import com.minhaempresa.servicos.exception.MinhaEmpresaAlreadyRegistredException;
import com.minhaempresa.servicos.exception.MinhaEmpresaNotFoundException;
import com.minhaempresa.servicos.adapter.MinhaEmpresaAdapter;
import com.minhaempresa.servicos.repository.MinhaEmpresaRepository;
import com.minhaempresa.servicos.services.MinhaEmpresaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class MinhaEmpresaServiceImpl implements MinhaEmpresaService {

    private final MinhaEmpresaRepository minhaEmpresaRepository;

    @Autowired
    public MinhaEmpresaServiceImpl(MinhaEmpresaRepository minhaEmpresaRepository) {
        this.minhaEmpresaRepository = minhaEmpresaRepository;
    }

    @Override
    public MinhaEmpresaDTO createMinhaEmpresa(MinhaEmpresaDTO minhaEmpresaDTO) throws MinhaEmpresaAlreadyRegistredException {
        verifyIfIsAlreadyRegistred(minhaEmpresaDTO.getNomeEmpresa());
        MinhaEmpresaEntity minhaEmpresa = new MinhaEmpresaAdapter(minhaEmpresaDTO).getMinhaEmpresaEntity();
        MinhaEmpresaEntity savedMinhaEmpresa = minhaEmpresaRepository.save(minhaEmpresa);
        return new MinhaEmpresaAdapter(savedMinhaEmpresa).getMinhaEmpresaDTO();
    }

    @Override
    public MinhaEmpresaDTO findById(Long id) throws MinhaEmpresaNotFoundException{
        MinhaEmpresaEntity foundMinhaEmpresa = verifyIfExists(id);
        return new MinhaEmpresaAdapter(foundMinhaEmpresa).getMinhaEmpresaDTO();
    }

    @Override
    public List<MinhaEmpresaDTO> listAll(){
        return new MinhaEmpresaAdapter(minhaEmpresaRepository.findAll()).getMinhaEmpresaDTOList();
    }

    @Override
    public void deleteById(Long id) throws MinhaEmpresaNotFoundException {
        verifyIfExists(id);
        minhaEmpresaRepository.deleteById(id);
    }

    private MinhaEmpresaEntity verifyIfExists(Long id) throws MinhaEmpresaNotFoundException{
        return minhaEmpresaRepository.findById(id)
                .orElseThrow(() -> new MinhaEmpresaNotFoundException(id));
    }

    private void verifyIfIsAlreadyRegistred(String name) throws MinhaEmpresaAlreadyRegistredException {
        Optional<MinhaEmpresaEntity> optSavedBeer = minhaEmpresaRepository.findByNomeEmpresa(name);
        if(optSavedBeer.isPresent()){
            throw new MinhaEmpresaAlreadyRegistredException(name);
        }
    }
}