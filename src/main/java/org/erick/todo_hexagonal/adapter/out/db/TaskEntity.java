package org.erick.todo_hexagonal.adapter.out.db;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private LocalDateTime dueDate;
	private StatusTaskEntity status;
	
	public TaskEntity() {

	}

	public TaskEntity(Long id, String description, LocalDateTime dueDate, StatusTaskEntity status) {
		super();
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
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
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public StatusTaskEntity getStatus() {
		return status;
	}
	public void setStatus(StatusTaskEntity status) {
		this.status = status;
	}
	
}
