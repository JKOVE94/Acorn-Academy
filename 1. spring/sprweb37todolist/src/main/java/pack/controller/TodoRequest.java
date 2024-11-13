package pack.controller;

import lombok.Getter;
import lombok.Setter;
import pack.model.TodoEntity;
import pack.model.TodoResponse;

@Setter
@Getter
public class TodoRequest { //FormBean
	private String title;
	private Integer order; 
	private Boolean completed;
	
	public static TodoEntity toEntity (TodoRequest request) {
		return TodoEntity.builder()
				.title(request.getTitle())
				.order(request.getOrder())
				.completed(request.getCompleted())
				.build();
	}
}
