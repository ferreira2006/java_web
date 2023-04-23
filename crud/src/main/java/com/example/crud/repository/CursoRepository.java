package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
