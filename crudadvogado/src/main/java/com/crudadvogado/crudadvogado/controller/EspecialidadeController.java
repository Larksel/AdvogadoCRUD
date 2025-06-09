package com.crudadvogado.crudadvogado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudadvogado.crudadvogado.entity.Especialidade;
import com.crudadvogado.crudadvogado.service.EspecialidadeService;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadeController {
    
    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Especialidade> especialidades = especialidadeService.findAll();
        model.addAttribute("especialidades", especialidades);
        return "/especialidade/listaEspecialidades";
    }
    
    @GetMapping("/criar")
    public String criarFrom(Model model) {
        model.addAttribute("especialidade", new Especialidade());
        return "especialidade/formularioEspecialidade";
    }

    @PostMapping("salvar")
    public String salvar(@ModelAttribute Especialidade especialidade) {
        especialidadeService.save(especialidade);
        return "redirect:/especialidades/listar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) 
    {
        especialidadeService.deleteById(id);
        return "redirect:/especialidades/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Especialidade especialidade = especialidadeService.findById(id);
        model.addAttribute("especialidade", especialidade);
        
        return "especialidade/formularioEspecialidade";
    }

}
