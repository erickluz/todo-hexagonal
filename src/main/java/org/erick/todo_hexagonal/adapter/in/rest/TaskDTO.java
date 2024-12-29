package org.erick.todo_hexagonal.adapter.in.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.erick.todo_hexagonal.core.domain.StatusTask;
import org.erick.todo_hexagonal.core.domain.Task;

public class TaskDTO {
	private Long id;
	private String description;
	private String dueDate;
	private String status;
	
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
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Task toTask() {
		LocalDateTime dueDate = LocalDateTime.parse(this.dueDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return new Task(this.id, this.description, dueDate, StatusTask.fromString(this.status));
	}
	
	
}
