package org.erick.todo_hexagonal.core.domain;

import java.time.LocalDateTime;

public class Task {
	private Long id;
	private String description;
	private LocalDateTime dueDate;
	private StatusTask status;
	
	public Task(Long id, String description, LocalDateTime dueDate, StatusTask status) {
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
	public StatusTask getStatus() {
		return status;
	}
	public void setStatus(StatusTask status) {
		this.status = status;
	}
	
}
