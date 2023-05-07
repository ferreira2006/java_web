package io.github.ferreira2006.tarefas.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TarefaDto {
	
	
	@NotBlank
	@Size(min = 4)
	private String description;

	private Boolean done;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createdDate;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime doneDate;

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

}
