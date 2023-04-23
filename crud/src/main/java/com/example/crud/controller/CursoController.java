package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.crud.model.Curso;
import com.example.crud.service.CursoService;

@Controller
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/")
	public String home(Model model) {
	    List<Curso> listaDeCursos = cursoService.listAll();
	    model.addAttribute("listaDeCursos", listaDeCursos);
	    return "index";
	}
	
	@GetMapping("/novo")
	public String showNewProductPage(Model model) {
	    Curso curso = new Curso();
	    model.addAttribute("curso", curso); 
	    return "novo_curso";
	}
	
	@PostMapping("/salvar")
	public String salvarCurso(@ModelAttribute("curso") Curso curso) {
	    cursoService.save(curso);
	    return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView exibirEditarProduto(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("editar_curso");
	    Curso curso  = cursoService.get(id);
	    mav.addObject("curso", curso);
	     
	    return mav;
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarCurso(@PathVariable(name = "id") Long id) {
	    cursoService.delete(id);
	    return "redirect:/";       
	}
	

}
