package io.github.ferreira2006.tarefas;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.ferreira2006.tarefas.model.Tarefa;
import io.github.ferreira2006.tarefas.repository.TarefaRepository;

@SpringBootApplication
public class TarefasApplication {
	
	@Autowired
	private TarefaRepository repository;

	@Bean
	public CommandLineRunner init() {
		return new CommandLineRunner() {	
			@Override
			public void run(String... args) throws Exception {
				Tarefa novaTarefa = new Tarefa();
				novaTarefa.setDescription("Primeira tarefa");
				novaTarefa.setCreatedDate(LocalDateTime.now());
				novaTarefa.setDone(false);
				novaTarefa.setDoneDate(null);
				
				repository.save(novaTarefa);
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

}
