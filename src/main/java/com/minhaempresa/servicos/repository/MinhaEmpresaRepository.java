package com.minhaempresa.servicos.repository;

import com.minhaempresa.servicos.bd.entities.MinhaEmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MinhaEmpresaRepository extends JpaRepository<MinhaEmpresaEntity,Long> {
    Optional<MinhaEmpresaEntity> findByNomeEmpresa(String name);

}
