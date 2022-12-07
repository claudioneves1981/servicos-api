package com.minhaempresa.servicos.repository;

import com.minhaempresa.servicos.bd.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Long> {
        Optional<ProdutoEntity> findByProduto(String name);
}
