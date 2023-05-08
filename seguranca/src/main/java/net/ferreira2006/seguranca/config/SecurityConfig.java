package net.ferreira2006.seguranca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//Filtros (Filters)
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(
						authorizeConfig -> {
							// Requisições que não precisam autenticação
							authorizeConfig.requestMatchers("/public").permitAll();
							authorizeConfig.requestMatchers("/logout").permitAll();
							
							// Todas as requisições restantes devem ser autenticadas
							authorizeConfig.anyRequest().authenticated();
						})
				.formLogin(Customizer.withDefaults())
				.build();
	}
	
}
