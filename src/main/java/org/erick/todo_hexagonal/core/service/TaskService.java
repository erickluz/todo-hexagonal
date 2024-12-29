package org.erick.todo_hexagonal.core.service;

import java.util.List;

import org.erick.todo_hexagonal.core.domain.Task;
import org.erick.todo_hexagonal.port.in.TaskPort;
import org.erick.todo_hexagonal.port.out.RepositoryTaskPort;

public class TaskService implements TaskPort {
	
	private RepositoryTaskPort repository;
	
	public TaskService(RepositoryTaskPort repository) {
		this.repository = repository;
	}

	@Override
	public Task getTask(Long id) {
		return repository.getTask(id);
	}
	
	@Override
	public Task createTask(Task task) {
		return repository.save(task);
	}

	@Override
	public List<Task> listTask() {
		return repository.list();
	}

	@Override
	public Task updateTask(Task task) {
		return repository.update(task);
	}

	@Override
	public void deleteTask(Long idTask) {
		repository.delete(idTask);
	}

}
