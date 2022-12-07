package com.minhaempresa.servicos.adapter;

import com.minhaempresa.servicos.bd.entities.MinhaEmpresaEntity;
import com.minhaempresa.servicos.bd.entities.UfEntity;
import com.minhaempresa.servicos.dto.MinhaEmpresaDTO;
import com.minhaempresa.servicos.dto.UfDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MinhaEmpresaAdapter {


    private MinhaEmpresaEntity minhaEmpresaEntity;
    private MinhaEmpresaDTO minhaEmpresaDTO;
    private List<MinhaEmpresaDTO> minhaEmpresaDTOList;

    public MinhaEmpresaAdapter(MinhaEmpresaEntity minhaEmpresaEntity) {
        minhaEmpresaDTO = toDTO(minhaEmpresaEntity);
    }

    public MinhaEmpresaAdapter(MinhaEmpresaDTO minhaEmpresaDTO) {
        minhaEmpresaEntity = toModel(minhaEmpresaDTO);
    }

    public MinhaEmpresaAdapter(List<MinhaEmpresaEntity> minhaEmpresaEntityList) {
        minhaEmpresaDTOList = toDTOList(minhaEmpresaEntityList);
    }

    private MinhaEmpresaDTO toDTO(MinhaEmpresaEntity minhaEmpresaEntity) {

        return MinhaEmpresaDTO.builder()
                .minhaEmpresaID(minhaEmpresaEntity.getMinhaEmpresaID())
                .CEP(minhaEmpresaEntity.getCEP())
                .cidade(minhaEmpresaEntity.getCidade())
                .fax(minhaEmpresaEntity.getFax())
                .paisRegiao(minhaEmpresaEntity.getPaisRegiao())
                .telefone(minhaEmpresaEntity.getTelefone())
                .aliquotaImpostoServico(minhaEmpresaEntity.getAliquotaImpostoServico())
                .descricaoFaturaPadrao(minhaEmpresaEntity.getDescricaoFaturaPadrao())
                .endereco(minhaEmpresaEntity.getEndereco())
                .nomeEmpresa(minhaEmpresaEntity.getNomeEmpresa())
                .termoPgtoPadrao(minhaEmpresaEntity.getTermoPgtoPadrao())
                .ufID(UfDTO.builder()
                        .ufID(minhaEmpresaEntity.getUfID().getUfID())
                        .descricao(minhaEmpresaEntity.getUfID().getDescricao())
                        .sigla(minhaEmpresaEntity.getUfID().getSigla())
                        .build())
                .build();
    }

    private MinhaEmpresaEntity toModel(MinhaEmpresaDTO minhaEmpresaDTO) {

        return MinhaEmpresaEntity.builder()
                .minhaEmpresaID(minhaEmpresaDTO.getMinhaEmpresaID())
                .CEP(minhaEmpresaDTO.getCEP())
                .cidade(minhaEmpresaDTO.getCidade())
                .fax(minhaEmpresaDTO.getFax())
                .paisRegiao(minhaEmpresaDTO.getPaisRegiao())
                .telefone(minhaEmpresaDTO.getTelefone())
                .aliquotaImpostoServico(minhaEmpresaDTO.getAliquotaImpostoServico())
                .descricaoFaturaPadrao(minhaEmpresaDTO.getDescricaoFaturaPadrao())
                .endereco(minhaEmpresaDTO.getEndereco())
                .nomeEmpresa(minhaEmpresaDTO.getNomeEmpresa())
                .termoPgtoPadrao(minhaEmpresaDTO.getTermoPgtoPadrao())
                .ufID(UfEntity.builder()
                        .ufID(minhaEmpresaDTO.getUfID().getUfID())
                        .descricao(minhaEmpresaDTO.getUfID().getDescricao())
                        .sigla(minhaEmpresaDTO.getUfID().getSigla())
                        .build())
                .build();
    }

    private List<MinhaEmpresaDTO> toDTOList(List<MinhaEmpresaEntity> minhaEmpresaEntityList){
        minhaEmpresaDTOList = new ArrayList<>();
        for(MinhaEmpresaEntity minhaEmpresaEntity : minhaEmpresaEntityList){
            minhaEmpresaDTOList.add(toDTO(minhaEmpresaEntity));
        }
        return minhaEmpresaDTOList;
    }
}
