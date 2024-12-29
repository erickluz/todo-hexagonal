package org.erick.todo_hexagonal.core.domain;

public enum StatusTask {
	PENDING,
	IN_PROGRESS,
	COMPLETED;
		
	public static StatusTask fromString(String task) {
		switch (task) {
			case "PENDING": return PENDING;
			case "IN_PROGRESS": return IN_PROGRESS;
			case "COMPLETED": return COMPLETED;
			default: throw new IllegalArgumentException();
		}
		
	}
}
