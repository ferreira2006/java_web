package net.ferreira2006.seguranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SegurancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegurancaApplication.class, args);
		
	}
	
	@RestController
	class HttpController {
		
		@GetMapping("/public")
		String publicRoute() {
			return "<h1>Plublic route, feel to lock around!</h1>";
			
		}
		
		@GetMapping("/private")
		String privateRoute() {
			return "<h1>Private route, only authorized personal!</h1>";
			
		}
	}

}
