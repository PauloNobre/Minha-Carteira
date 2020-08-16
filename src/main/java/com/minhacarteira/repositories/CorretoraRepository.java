package com.minhacarteira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhacarteira.entities.Corretora;

@Repository
public interface CorretoraRepository extends JpaRepository<Corretora, Integer>{

}