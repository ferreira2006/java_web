package io.github.ferreira2006.tarefas.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ferreira2006.tarefas.dto.TarefaDto;
import io.github.ferreira2006.tarefas.model.Tarefa;
import io.github.ferreira2006.tarefas.repository.TarefaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tarefas")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TarefaController {

	@Autowired
	private TarefaRepository repository;
	
	@PostMapping
	public ResponseEntity<Object> save( @RequestBody @Valid TarefaDto tarefaDto ) {
		  var tarefaModel = new Tarefa();
	        BeanUtils.copyProperties(tarefaDto, tarefaModel);
	        tarefaModel.setCreatedDate(LocalDateTime.now(ZoneId.of("UTC")));
	        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tarefaModel));
	}
	
	 @GetMapping
	    public ResponseEntity<Page<Tarefa>> getAllTarefas(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
	        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll(pageable));
	    }
	
	 @GetMapping("/{id}")/* @PathVariable é passado pelo cliente na chamada */
	    public ResponseEntity<Object> getOneById(@PathVariable(value = "id") Long id){
	        Optional<Tarefa> tarefaModelOptional = repository.findById(id);
	        if (!tarefaModelOptional.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa inexistente!");
	        }
	        return ResponseEntity.status(HttpStatus.OK).body(tarefaModelOptional.get());
	    }
	
	 	@DeleteMapping("/{id}")
	    public ResponseEntity<Object> deleteTarefa(@PathVariable(value = "id") Long id){
	        Optional<Tarefa> tarefaModelOptional = repository.findById(id);
	        if (!tarefaModelOptional.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa inexistente!.");
	        }
	        repository.delete(tarefaModelOptional.get());
	        return ResponseEntity.status(HttpStatus.OK).body("Tarefa Excluída com sucesso!");
	    }
	
	@PatchMapping("{id}/done")
	public Tarefa markAsDone( @PathVariable Long id) {
		return repository.findById(id).map(tarefa -> {
			tarefa.setDone(true);
			tarefa.setDoneDate(LocalDateTime.now());
			repository.save(tarefa);
			return tarefa;
		}).orElse(null);
	}
	

	 	@PutMapping("/{id}")
	    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") Long id,
	                                                    @RequestBody @Valid TarefaDto tarefaDto){
	        Optional<Tarefa> tarefaModelOptional = repository.findById(id);
	        if (!tarefaModelOptional.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não existe!");
	        }
	        var tarefaModel = new Tarefa();
	        BeanUtils.copyProperties(tarefaDto, tarefaModel);
	        tarefaModel.setId(tarefaModelOptional.get().getId());
	        tarefaModel.setCreatedDate(tarefaModelOptional.get().getCreatedDate());
	        return ResponseEntity.status(HttpStatus.OK).body(repository.save(tarefaModel));
	    }
}