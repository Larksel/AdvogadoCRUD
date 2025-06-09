package com.crudadvogado.crudadvogado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudadvogado.crudadvogado.entity.Advogado;

public interface AdvogadoRepository extends JpaRepository<Advogado, Integer> {
    
}
