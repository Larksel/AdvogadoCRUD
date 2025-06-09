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

import com.crudadvogado.crudadvogado.entity.Advogado;
import com.crudadvogado.crudadvogado.service.AdvogadoService;
import com.crudadvogado.crudadvogado.service.EspecialidadeService;

@Controller
@RequestMapping("/advogados")
public class AdvogadoController {
    
    @Autowired
    private AdvogadoService advogadoService;

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Advogado> advogados = advogadoService.findAll();
        model.addAttribute("advogados", advogados);
        return "/advogado/listaAdvogados";
    }
    
    @GetMapping("/criar")
    public String criarFrom(Model model) {
        model.addAttribute("advogado", new Advogado());
        model.addAttribute("especialidades", especialidadeService.findAll());
        return "advogado/formularioAdvogado";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Advogado advogado) {
        advogadoService.save(advogado);
        return "redirect:/advogados/listar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) 
    {
        advogadoService.deleteById(id);
        return "redirect:/advogados/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Advogado advogado = advogadoService.findById(id);
        model.addAttribute("advogado", advogado);
        model.addAttribute("especialidades", especialidadeService.findAll());
        
        return "advogado/formularioAdvogado";
    }

}
