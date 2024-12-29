package org.erick.todo_hexagonal.configuration;

import org.erick.todo_hexagonal.core.service.TaskService;
import org.erick.todo_hexagonal.port.in.TaskPort;
import org.erick.todo_hexagonal.port.out.RepositoryTaskPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {

	@Bean
	public TaskPort createTaskService(RepositoryTaskPort repositoryTaskPort) {
		return new TaskService(repositoryTaskPort);
	}
	
}
