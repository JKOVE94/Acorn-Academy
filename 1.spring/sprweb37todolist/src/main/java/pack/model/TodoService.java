package pack.model;

import java.util.List;

import pack.controller.TodoRequest;

public interface TodoService {

	TodoResponse add(TodoRequest request);
	TodoResponse serchById(Integer id);
	List<TodoResponse> searchAll();
	TodoResponse updateById(Integer id, TodoRequest request);
	void deleteById(Integer id);
	void deleteAll();
}
