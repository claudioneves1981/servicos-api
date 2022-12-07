package com.minhaempresa.servicos.repository;

import com.minhaempresa.servicos.bd.entities.ClienteEntity;
import com.minhaempresa.servicos.bd.entities.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
    Optional<FuncionarioEntity> findByNome(String name);
}
