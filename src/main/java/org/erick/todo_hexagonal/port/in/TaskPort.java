package org.erick.todo_hexagonal.port.in;

import java.util.List;

import org.erick.todo_hexagonal.core.domain.Task;

public interface TaskPort {
	Task getTask(Long id);
	Task createTask(Task task);
	List<Task> listTask();
	Task updateTask(Task task);
	void deleteTask(Long idTask);
}
