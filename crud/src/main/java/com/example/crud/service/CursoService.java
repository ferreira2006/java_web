package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Curso;
import com.example.crud.repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	 public List<Curso> listAll() {
	        return cursoRepository.findAll();
	    }
	     
	    public void save(Curso curso) {
	        cursoRepository.save(curso);
	    }
	     
	    public Curso get(Long id) {
	        return cursoRepository.findById(id).get();
	    }
	     
	    public void delete(Long id) {
	       cursoRepository.deleteById(id);
	    }
	
}
