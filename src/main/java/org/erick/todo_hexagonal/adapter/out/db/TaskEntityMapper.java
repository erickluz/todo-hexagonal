package org.erick.todo_hexagonal.adapter.out.db;

import java.util.List;
import java.util.stream.Collectors;

import org.erick.todo_hexagonal.core.domain.StatusTask;
import org.erick.todo_hexagonal.core.domain.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskEntityMapper {
	
	protected List<TaskEntity> fromTasks(List<Task> tasks) {
		return tasks.stream().map(t -> fromTask(t)).collect(Collectors.toList());
	}
	
	protected List<Task> toTasks(List<TaskEntity> tasks) {
		return tasks.stream().map(t -> toTask(t)).collect(Collectors.toList());
	}
	
	protected TaskEntity fromTask(Task task) {
		StatusTaskEntity status = getStatus(task.getStatus());
		return new TaskEntity(task.getId(), task.getDescription(), task.getDueDate(), status);
	}
	
	protected Task toTask(TaskEntity taskEntity) {
		StatusTask status = getStatus(taskEntity.getStatus());
		return new Task(taskEntity.getId(), taskEntity.getDescription(), taskEntity.getDueDate(), status);
	}

	private StatusTask getStatus(StatusTaskEntity status) {
		switch (status) {
			case COMPLETED: return StatusTask.COMPLETED;
			case PENDING: return StatusTask.PENDING;
			case IN_PROGRESS: return StatusTask.IN_PROGRESS;
			default: return null;
		}
	}

	private StatusTaskEntity getStatus(StatusTask status) {
		switch (status) {
			case COMPLETED: return StatusTaskEntity.COMPLETED;
			case PENDING: return StatusTaskEntity.PENDING;
			case IN_PROGRESS: return StatusTaskEntity.IN_PROGRESS;
			default: return null;
		}
	}

}
