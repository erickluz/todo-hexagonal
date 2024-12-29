package org.erick.todo_hexagonal.port.out;

import java.util.List;

import org.erick.todo_hexagonal.core.domain.Task;

public interface RepositoryTaskPort {
	Task getTask(Long id);
	Task save(Task task);
	List<Task> list();
	Task update(Task task);
	void delete(Long idTask);
}
