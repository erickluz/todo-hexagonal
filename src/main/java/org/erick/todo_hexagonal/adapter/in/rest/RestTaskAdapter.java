package org.erick.todo_hexagonal.adapter.in.rest;

import java.net.URI;
import java.util.List;

import org.erick.todo_hexagonal.core.domain.Task;
import org.erick.todo_hexagonal.port.in.TaskPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/task")
public class RestTaskAdapter {
	
	@Autowired
	private TaskPort taskService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTask(@PathVariable(required = true) Long id) {
		Task task = taskService.getTask(id);
		return ResponseEntity.ok(task);
	}
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody TaskDTO task) {
		Task taskCreated = taskService.createTask(task.toTask());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(taskCreated.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> listTask() {
		List<Task> tasks = taskService.listTask();
		return ResponseEntity.ok(tasks);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateTask(@RequestBody TaskDTO task) {
		taskService.updateTask(task.toTask());
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable(required = true) Long id) {
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}

}
