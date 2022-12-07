package com.minhaempresa.servicos.adapter;

import com.minhaempresa.servicos.bd.entities.ClienteEntity;
import com.minhaempresa.servicos.bd.entities.UfEntity;
import com.minhaempresa.servicos.dto.ClienteDTO;
import com.minhaempresa.servicos.dto.UfDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteAdapter {

    private ClienteEntity clienteEntity;
    private ClienteDTO clienteDTO;
    private List<ClienteDTO> clienteDTOList;

    public ClienteAdapter(ClienteEntity clienteEntity){
        clienteDTO = toDTO(clienteEntity);
    }

    public ClienteAdapter(ClienteDTO clienteDTO){
        clienteEntity = toModel(clienteDTO);
    }

    public ClienteAdapter(List<ClienteEntity> clienteEntityList){
        clienteDTOList = toDTOList(clienteEntityList);
    }

     private ClienteDTO toDTO(ClienteEntity clienteEntity) {

        return ClienteDTO.builder()
                .ID(clienteEntity.getID())
                .ufID(UfDTO.builder()
                        .ufID(clienteEntity.getUfID().getUfID())
                        .sigla(clienteEntity.getUfID().getSigla())
                        .descricao(clienteEntity.getUfID().getDescricao())
                        .build())
                .tituloContato(clienteEntity.getTituloContato())
                .telefone(clienteEntity.getTelefone())
                .sobrenomeContato(clienteEntity.getSobrenomeContato())
                .paisRegiao(clienteEntity.getPaisRegiao())
                .observacao(clienteEntity.getObservacao())
                .nomeDaEmpresa(clienteEntity.getNomeDaEmpresa())
                .nomeContato(clienteEntity.getNomeContato())
                .fax(clienteEntity.getFax())
                .email(clienteEntity.getEmail())
                .dataDeCadastro(clienteEntity.getDataDeCadastro())
                .cidade(clienteEntity.getCidade())
                .CEP(clienteEntity.getCEP())
                .enderecoCobranca(clienteEntity.getEnderecoCobranca())
                .build();
    }

    private ClienteEntity toModel(ClienteDTO clienteDTO) {

        return ClienteEntity.builder()
                .ID(clienteDTO.getID())
                .ufID(UfEntity.builder()
                        .ufID(clienteDTO.getUfID().getUfID())
                        .sigla(clienteDTO.getUfID().getSigla())
                        .descricao(clienteDTO.getUfID().getDescricao())
                        .build())
                .tituloContato(clienteDTO.getTituloContato())
                .telefone(clienteDTO.getTelefone())
                .sobrenomeContato(clienteDTO.getSobrenomeContato())
                .paisRegiao(clienteDTO.getPaisRegiao())
                .observacao(clienteDTO.getObservacao())
                .nomeDaEmpresa(clienteDTO.getNomeDaEmpresa())
                .nomeContato(clienteDTO.getNomeContato())
                .fax(clienteDTO.getFax())
                .email(clienteDTO.getEmail())
                .dataDeCadastro(clienteDTO.getDataDeCadastro())
                .cidade(clienteDTO.getCidade())
                .CEP(clienteDTO.getCEP())
                .enderecoCobranca(clienteDTO.getEnderecoCobranca())
                .build();
    }

    private List<ClienteDTO> toDTOList(List<ClienteEntity> clienteEntityList){
        clienteDTOList = new ArrayList<>();
        for(ClienteEntity clienteEntity : clienteEntityList){
            clienteDTOList.add(toDTO(clienteEntity));
        }
        return clienteDTOList;
    }
}
