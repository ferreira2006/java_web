package info.ferreira2006.cadastroweb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	                .httpBasic()
	                .and()
	                .authorizeHttpRequests()
	                .requestMatchers(HttpMethod.POST, "/usuarios/login").permitAll()
//	                .antMatchers(HttpMethod.POST, "/parking-spot").hasRole("USER")
//	                .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN")
	                .anyRequest().authenticated().and().cors()
	                .and()
	                .csrf().disable();
	        http.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
}
