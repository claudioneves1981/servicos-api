package com.minhaempresa.servicos.services.impl;

import com.minhaempresa.servicos.bd.entities.FuncionarioEntity;
import com.minhaempresa.servicos.dto.FuncionarioDTO;
import com.minhaempresa.servicos.exception.FuncionarioAlreadyRegistredException;
import com.minhaempresa.servicos.exception.FuncionarioNotFoundException;
import com.minhaempresa.servicos.adapter.FuncionarioAdapter;
import com.minhaempresa.servicos.repository.FuncionarioRepository;
import com.minhaempresa.servicos.services.FuncionarioService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioAlreadyRegistredException {
        verifyIfIsAlreadyRegistred(funcionarioDTO.getNome());
        FuncionarioEntity funcionario = new FuncionarioAdapter(funcionarioDTO).getFuncionarioEntity();
        FuncionarioEntity savedFuncionario = funcionarioRepository.save(funcionario);
        return new FuncionarioAdapter(savedFuncionario).getFuncionarioDTO();
    }

    @Override
    public FuncionarioDTO findById(Long id) throws FuncionarioNotFoundException{
        FuncionarioEntity foundFuncionario = verifyIfExists(id);
        return new FuncionarioAdapter(foundFuncionario).getFuncionarioDTO();
    }

    @Override
    public List<FuncionarioDTO> listAll(){
        return new FuncionarioAdapter(funcionarioRepository.findAll()).getFuncionarioDTOList();
    }

    @Override
    public void deleteById(Long id) throws FuncionarioNotFoundException {
        verifyIfExists(id);
        funcionarioRepository.deleteById(id);
    }

    private FuncionarioEntity verifyIfExists(Long id) throws FuncionarioNotFoundException{
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id));
    }

    private void verifyIfIsAlreadyRegistred(String name) throws FuncionarioAlreadyRegistredException {
        Optional<FuncionarioEntity> optSavedBeer = funcionarioRepository.findByNome(name);
        if(optSavedBeer.isPresent()){
            throw new FuncionarioAlreadyRegistredException(name);
        }
    }
}
