package io.github.ferreira2006.tarefas.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@Column
	private Boolean done = false;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createdDate;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime doneDate;

	@PrePersist
	public void beforeSave() {
		setCreatedDate(LocalDateTime.now());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(LocalDateTime doneDate) {
		this.doneDate = doneDate;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
}
