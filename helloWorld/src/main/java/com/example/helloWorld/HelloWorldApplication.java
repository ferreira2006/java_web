package com.example.helloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* A anotação @SpringBootApplication indica que classe faz parte da configuração do Spring e e irá scanear todas as 
classes a partir deste pacote (com.example.helloWorld) se encontar outros componentes (classes
anotadas) spring o próprio framework spring fará o gerenciamento delas */

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
