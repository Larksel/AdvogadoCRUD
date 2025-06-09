package com.crudadvogado.crudadvogado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudadvogado.crudadvogado.entity.Advogado;
import com.crudadvogado.crudadvogado.repository.AdvogadoRepository;

@Service
public class AdvogadoService {
    
    @Autowired
    private AdvogadoRepository advogadoRepository;

    public List<Advogado> findAll(){
        return advogadoRepository.findAll();
    }
    
    public Advogado save(Advogado advogado)
    {
        return advogadoRepository .save(advogado);
    }

    public void deleteById(Integer id)
    {
        advogadoRepository.deleteById(id);
    }

    public Advogado findById(Integer id) {
        return advogadoRepository.findById(id).orElse(null);
    }
}
