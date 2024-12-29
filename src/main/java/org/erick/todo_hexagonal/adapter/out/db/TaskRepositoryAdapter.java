package org.erick.todo_hexagonal.adapter.out.db;

import java.util.List;

import org.erick.todo_hexagonal.core.domain.Task;
import org.erick.todo_hexagonal.port.out.RepositoryTaskPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskRepositoryAdapter implements RepositoryTaskPort {
	
	@Autowired
	private TaskRepository repository;
	@Autowired
	private TaskEntityMapper mapper;

	@Override
	public Task getTask(Long id) {
		return mapper.toTask(repository.getReferenceById(id));
	}

	@Override
	public Task save(Task task) {
		return mapper.toTask(repository.save(mapper.fromTask(task)));
	}

	@Override
	public List<Task> list() {
		return mapper.toTasks(repository.findAll());
	}

	@Override
	public Task update(Task task) {
		return mapper.toTask(repository.save(mapper.fromTask(task)));
	}

	@Override
	public void delete(Long idTask) {
		repository.deleteById(idTask);
	}
	

}
