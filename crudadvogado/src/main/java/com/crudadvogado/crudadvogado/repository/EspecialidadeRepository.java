package com.crudadvogado.crudadvogado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudadvogado.crudadvogado.entity.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
    
}
