package com.crudadvogado.crudadvogado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/crudadvogado")
public class CrudAdvogadoController {

  @GetMapping
  public String index(Model model) {
    // Retorna a página index.html
    return "/index";
  }
  
}
