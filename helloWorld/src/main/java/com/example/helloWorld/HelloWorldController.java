package com.example.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@GetMapping("/saudacao")
	public String ola(@RequestParam(name="nome", required=false, defaultValue="World") String nome, Model model) {
		model.addAttribute("nome", nome);
		
		return "saudacao";
	}
}
