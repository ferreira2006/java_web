package io.github.ferreira2006.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.ferreira2006.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	

}
