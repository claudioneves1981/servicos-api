package com.minhaempresa.servicos.services.impl;

import com.minhaempresa.servicos.adapter.ClienteAdapter;
import com.minhaempresa.servicos.bd.entities.ClienteEntity;
import com.minhaempresa.servicos.dto.ClienteDTO;
import com.minhaempresa.servicos.exception.ClienteAlreadyRegistredException;
import com.minhaempresa.servicos.exception.ClienteNotFoundException;
import com.minhaempresa.servicos.repository.ClienteRepository;
import com.minhaempresa.servicos.services.ClienteService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteAlreadyRegistredException {
        verifyIfIsAlreadyRegistred(clienteDTO.getNomeContato());
        ClienteEntity cliente = new ClienteAdapter(clienteDTO).getClienteEntity();
        ClienteEntity savedCliente = clienteRepository.save(cliente);
        return new ClienteAdapter(savedCliente).getClienteDTO();
    }

    @Override
    public ClienteDTO findById(Long id) throws ClienteNotFoundException{
        ClienteEntity foundCliente = verifyIfExists(id);
        return new ClienteAdapter(foundCliente).getClienteDTO();
    }

    @Override
    public List<ClienteDTO> listAll(){
        return new ClienteAdapter(clienteRepository.findAll()).getClienteDTOList();
    }

    @Override
    public void deleteById(Long id) throws ClienteNotFoundException {
        verifyIfExists(id);
        clienteRepository.deleteById(id);
    }

    private ClienteEntity verifyIfExists(Long id) throws ClienteNotFoundException{
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    private void verifyIfIsAlreadyRegistred(String name) throws ClienteAlreadyRegistredException {
        Optional<ClienteEntity> optSavedBeer = clienteRepository.findByNomeContato(name);
        if(optSavedBeer.isPresent()){
            throw new ClienteAlreadyRegistredException(name);
        }
    }
}