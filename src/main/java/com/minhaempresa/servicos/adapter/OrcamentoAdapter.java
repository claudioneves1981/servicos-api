package com.minhaempresa.servicos.adapter;

import com.minhaempresa.servicos.bd.entities.*;
import com.minhaempresa.servicos.dto.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrcamentoAdapter {

    private OrcamentoEntity orcamentoEntity;
    private OrcamentoDTO orcamentoDTO;
    private List<OrcamentoDTO> orcamentoDTOList;

    public OrcamentoAdapter(OrcamentoDTO orcamentoDTO) {
        orcamentoEntity = toModel(orcamentoDTO);
    }
    public OrcamentoAdapter(OrcamentoEntity orcamentoEntity) {
        orcamentoDTO = toDTO(orcamentoEntity);
    }
    public OrcamentoAdapter(List<OrcamentoEntity> orcamentoEntityList) {
        orcamentoDTOList = toDTOList(orcamentoEntityList);
    }

    private OrcamentoDTO toDTO(OrcamentoEntity orcamentoEntity) {
        return OrcamentoDTO.builder()
                .orcID(orcamentoEntity.getOrcID())
                .funcionarioID(FuncionarioDTO.builder()
                        .funcId(orcamentoEntity.getFuncionarioID().getFuncId())
                        .cargo(orcamentoEntity.getFuncionarioID().getCargo())
                        .dataCadastro(orcamentoEntity.getFuncionarioID().getDataCadastro())
                        .escritorio(orcamentoEntity.getFuncionarioID().getEscritorio())
                        .nome(orcamentoEntity.getFuncionarioID().getNome())
                        .nomeEmail(orcamentoEntity.getFuncionarioID().getNomeEmail())
                        .ramal(orcamentoEntity.getFuncionarioID().getRamal())
                        .sobrenome(orcamentoEntity.getFuncionarioID().getSobrenome())
                        .taxaCobranca(orcamentoEntity.getFuncionarioID().getTaxaCobranca())
                        .telefoneComercial(orcamentoEntity.getFuncionarioID().getTelefoneComercial())
                        .build())
                .descricaoProbl(orcamentoEntity.getDescricaoProbl())
                .dataTermino(orcamentoEntity.getDataTermino())
                .dataRequerida(orcamentoEntity.getDataRequerida())
                .dataRecebimento(orcamentoEntity.getDataRecebimento())
                .dataColheita(orcamentoEntity.getDataColheita())
                .clienteID(ClienteDTO.builder()
                        .ID(orcamentoEntity.getClienteID().getID())
                        .ufID(UfDTO.builder()
                                .ufID(orcamentoEntity.getClienteID().getUfID().getUfID())
                                .sigla(orcamentoEntity.getClienteID().getUfID().getSigla())
                                .descricao(orcamentoEntity.getClienteID().getUfID().getDescricao())
                                .build())
                        .tituloContato(orcamentoEntity.getClienteID().getTituloContato())
                        .telefone(orcamentoEntity.getClienteID().getTelefone())
                        .sobrenomeContato(orcamentoEntity.getClienteID().getSobrenomeContato())
                        .paisRegiao(orcamentoEntity.getClienteID().getPaisRegiao())
                        .observacao(orcamentoEntity.getClienteID().getObservacao())
                        .nomeDaEmpresa(orcamentoEntity.getClienteID().getNomeDaEmpresa())
                        .nomeContato(orcamentoEntity.getClienteID().getNomeContato())
                        .fax(orcamentoEntity.getClienteID().getFax())
                        .email(orcamentoEntity.getClienteID().getEmail())
                        .dataDeCadastro(orcamentoEntity.getClienteID().getDataDeCadastro())
                        .cidade(orcamentoEntity.getClienteID().getCidade())
                        .CEP(orcamentoEntity.getClienteID().getCEP())
                        .enderecoCobranca(orcamentoEntity.getClienteID().getEnderecoCobranca())
                        .build())
                .aliquotaISS(orcamentoEntity.getAliquotaISS())
                .marcaModelo(orcamentoEntity.getMarcaModelo())
                .prdID(ProdutoDTO.builder()
                        .prodID(orcamentoEntity.getPrdID().getPrdID())
                        .descricaoParte(orcamentoEntity.getPrdID().getDescricaoParte())
                        .precoUnitario(orcamentoEntity.getPrdID().getPrecoUnitario())
                        .nomeDoProduto(orcamentoEntity.getPrdID().getProduto())
                        .build())
                .modelo(orcamentoEntity.getModelo())
                .dataPgto(orcamentoEntity.getDataPgto())
                .mpgDTO(MetodoPagamentoDTO.builder()
                        .metodoPagamentoID(orcamentoEntity.getMpgID().getMetodoPagamentoID())
                        .cartaoCredito(orcamentoEntity.getMpgID().getCartaoCredito())
                        .metodoPagamento(orcamentoEntity.getMpgID().getMetodoPagamento())
                        .build())
                .valor(orcamentoEntity.getValor())
                .quantidade(orcamentoEntity.getQuantidade())
                .build();

    }

    private OrcamentoEntity toModel(OrcamentoDTO orcamentoDTO){
        return OrcamentoEntity.builder()
                .funcionarioID(FuncionarioEntity.builder()
                        .cargo(orcamentoDTO.getFuncionarioID().getCargo())
                        .dataCadastro(orcamentoDTO.getFuncionarioID().getDataCadastro())
                        .escritorio(orcamentoDTO.getFuncionarioID().getEscritorio())
                        .nome(orcamentoDTO.getFuncionarioID().getNome())
                        .nomeEmail(orcamentoDTO.getFuncionarioID().getNomeEmail())
                        .ramal(orcamentoDTO.getFuncionarioID().getRamal())
                        .sobrenome(orcamentoDTO.getFuncionarioID().getSobrenome())
                        .taxaCobranca(orcamentoDTO.getFuncionarioID().getTaxaCobranca())
                        .telefoneComercial(orcamentoDTO.getFuncionarioID().getTelefoneComercial())
                        .build())
                .descricaoProbl(orcamentoDTO.getDescricaoProbl())
                .dataTermino(orcamentoDTO.getDataTermino())
                .dataRequerida(orcamentoDTO.getDataRequerida())
                .dataRecebimento(orcamentoDTO.getDataRecebimento())
                .dataColheita(orcamentoDTO.getDataColheita())
                .clienteID(ClienteEntity.builder()
                        .ufID(UfEntity.builder()
                                .sigla(orcamentoDTO.getClienteID().getUfID().getSigla())
                                .descricao(orcamentoDTO.getClienteID().getUfID().getDescricao())
                                .build())
                        .tituloContato(orcamentoDTO.getClienteID().getTituloContato())
                        .telefone(orcamentoDTO.getClienteID().getTelefone())
                        .sobrenomeContato(orcamentoDTO.getClienteID().getSobrenomeContato())
                        .paisRegiao(orcamentoDTO.getClienteID().getPaisRegiao())
                        .observacao(orcamentoDTO.getClienteID().getObservacao())
                        .nomeDaEmpresa(orcamentoDTO.getClienteID().getNomeDaEmpresa())
                        .nomeContato(orcamentoDTO.getClienteID().getNomeContato())
                        .fax(orcamentoDTO.getClienteID().getFax())
                        .email(orcamentoDTO.getClienteID().getEmail())
                        .dataDeCadastro(orcamentoDTO.getClienteID().getDataDeCadastro())
                        .cidade(orcamentoDTO.getClienteID().getCidade())
                        .CEP(orcamentoDTO.getClienteID().getCEP())
                        .enderecoCobranca(orcamentoDTO.getClienteID().getEnderecoCobranca())
                        .build())
                .aliquotaISS(orcamentoDTO.getAliquotaISS())
                .marcaModelo(orcamentoDTO.getMarcaModelo())
                .prdID(ProdutoEntity.builder()
                        .descricaoParte(orcamentoDTO.getPrdID().getDescricaoParte())
                        .precoUnitario(orcamentoDTO.getPrdID().getPrecoUnitario())
                        .produto(orcamentoDTO.getPrdID().getNomeDoProduto())
                        .build())
                .modelo(orcamentoDTO.getModelo())
                .dataPgto(orcamentoDTO.getDataPgto())
                .mpgID(MetodoPagamentoEntity.builder()
                        .metodoPagamento(orcamentoDTO.getMpgDTO().getMetodoPagamento())
                        .cartaoCredito(orcamentoDTO.getMpgDTO().getCartaoCredito())
                        .metodoPagamento(orcamentoDTO.getMpgDTO().getMetodoPagamento())
                        .build())
                .valor(orcamentoDTO.getValor())
                .quantidade(orcamentoDTO.getQuantidade())
                .build();
    }
    
    private List<OrcamentoDTO> toDTOList(List<OrcamentoEntity> orcamentoEntityList){
        orcamentoDTOList = new ArrayList<>();
        for(OrcamentoEntity orcamentoEntity : orcamentoEntityList){
            orcamentoDTOList.add(toDTO(orcamentoEntity));
        }
        return orcamentoDTOList;
    }
    


}
