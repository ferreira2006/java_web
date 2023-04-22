package com.example.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	/* A anotação @GetMapping indica a url que deve ser digitada no navegador para
	 * chamar este método ola() que retorna a página Hello http://localhost:8080/saudacao */
	@GetMapping("/saudacao")
	public String ola(@RequestParam(name="nome", required=false, defaultValue="World") String nome, Model model) {
		/* O método ola pede 2 parâmetros: String nome - Model model 
		 * a variável nome pode ser passado por quem fizer a requisição, caso negativo "world" será atribuida
		 *  Model é um implementação de uma interface gerérica do spring framework para tranbalhar com um Model
		 * */
		
		/* Adiciona um atributo composto por um nome e valor, estilo MAP (chave:valor) */
		model.addAttribute("nome", nome);
		
		/* é retornado ao navegador um novo arquivo HTML (saudacao.html) com o único valor
		 * que foi atribuido ao Model (o nome que foi encaminhado na requisição)
		 */
		
		return "saudacao";
	}
}
