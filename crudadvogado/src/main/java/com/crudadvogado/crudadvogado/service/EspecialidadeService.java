package com.crudadvogado.crudadvogado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudadvogado.crudadvogado.entity.Especialidade;
import com.crudadvogado.crudadvogado.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {
    
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> findAll(){
        return especialidadeRepository.findAll();
    }
    
    public Especialidade save(Especialidade especialidade)
    {
        return especialidadeRepository .save(especialidade);
    }

    public void deleteById(Integer id)
    {
        especialidadeRepository.deleteById(id);
    }

    public Especialidade findById(Integer id) {
        return especialidadeRepository.findById(id).orElse(null);
    }

}
