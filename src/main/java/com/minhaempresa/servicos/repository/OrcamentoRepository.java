package com.minhaempresa.servicos.repository;

import com.minhaempresa.servicos.bd.entities.MinhaEmpresaEntity;
import com.minhaempresa.servicos.bd.entities.OrcamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrcamentoEntity,Long> {
    Optional<OrcamentoEntity> findByModelo(String name);
}
