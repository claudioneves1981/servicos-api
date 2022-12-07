package com.minhaempresa.servicos.adapter;

import com.minhaempresa.servicos.bd.entities.FuncionarioEntity;
import com.minhaempresa.servicos.dto.FuncionarioDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FuncionarioAdapter {

    private FuncionarioEntity funcionarioEntity;
    private FuncionarioDTO funcionarioDTO;
    private List<FuncionarioDTO> funcionarioDTOList;

    public FuncionarioAdapter(FuncionarioEntity funcionarioEntity){
        funcionarioDTO = toDTO(funcionarioEntity);
    }

    public FuncionarioAdapter(FuncionarioDTO funcionarioDTO){
        funcionarioEntity = toModel(funcionarioDTO);
    }

    public FuncionarioAdapter(List<FuncionarioEntity> funcionarioEntityList){
        funcionarioDTOList = toDTOList(funcionarioEntityList);
    }
    private FuncionarioDTO toDTO(FuncionarioEntity funcionarioEntity) {
        return FuncionarioDTO.builder()
                .funcId(funcionarioEntity.getFuncId())
                .cargo(funcionarioEntity.getCargo())
                .dataCadastro(funcionarioEntity.getDataCadastro())
                .escritorio(funcionarioEntity.getEscritorio())
                .nome(funcionarioEntity.getNome())
                .nomeEmail(funcionarioEntity.getNomeEmail())
                .ramal(funcionarioEntity.getRamal())
                .sobrenome(funcionarioEntity.getSobrenome())
                .taxaCobranca(funcionarioEntity.getTaxaCobranca())
                .telefoneComercial(funcionarioEntity.getTelefoneComercial())
                .build();
    }


    private FuncionarioEntity toModel(FuncionarioDTO funcionarioDTO) {

       return FuncionarioEntity.builder()
                .funcId(funcionarioDTO.getFuncId())
                .cargo(funcionarioDTO.getCargo())
                .dataCadastro(funcionarioDTO.getDataCadastro())
                .escritorio(funcionarioDTO.getEscritorio())
                .nome(funcionarioDTO.getNome())
                .nomeEmail(funcionarioDTO.getNomeEmail())
                .ramal(funcionarioDTO.getRamal())
                .sobrenome(funcionarioDTO.getSobrenome())
                .taxaCobranca(funcionarioDTO.getTaxaCobranca())
                .telefoneComercial(funcionarioDTO.getTelefoneComercial())
                .build();
        
    }

    private List<FuncionarioDTO> toDTOList(List<FuncionarioEntity> funcionarioEntityList){
        funcionarioDTOList = new ArrayList<>();
        for(FuncionarioEntity funcionarioEntity : funcionarioEntityList){
            funcionarioDTOList.add(toDTO(funcionarioEntity));
        }
        return funcionarioDTOList;
    }
}
