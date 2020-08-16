package com.minhacarteira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhacarteira.entities.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Integer>{

}