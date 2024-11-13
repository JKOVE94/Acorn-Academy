package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pack.controller.TodoRequest;

@Service
public class TodoServiceImpl implements TodoService{
	
	private final TodoRepository todoRepository;
	
	TodoServiceImpl(TodoRepository todoRepository){
		this.todoRepository = todoRepository;
	}
	
	//todo 리스트에 데이터 추가
	@Override
	public TodoResponse add(TodoRequest request) { //FormBean을 toEntity
		TodoEntity todoEntity = TodoEntity.builder()
				.title(request.getTitle())
				.order(request.getOrder())
				.completed(request.getCompleted()).build();
		
		return TodoResponse.fromEntity(todoRepository.save(todoEntity));
	}
	
	//항목 조회
	@Override
	public TodoResponse serchById(Integer id) {
		System.out.println("id :  "+id);
		return TodoResponse.fromEntity(todoRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND))); //HTTP의 상태로 출력할 수 있는 방법
	}
	
	//전체 조회
	@Override
	public List<TodoResponse> searchAll(){
		return todoRepository.findAll().stream()
				.map(TodoResponse :: fromEntity)
				.collect(Collectors.toList());
	}
	
	//수정
	@Override
	public TodoResponse updateById(Integer id, TodoRequest request) {
		TodoEntity todoEntity = TodoResponse.toEntity(serchById(id));
		
		if(request.getTitle() != null) {
			todoEntity.setTitle(request.getTitle());
		}
		if(request.getOrder()!= null) {
			todoEntity.setOrder(request.getOrder());
		}
		if(request.getCompleted() != null) {
			todoEntity.setCompleted(request.getCompleted());
		}
		return TodoResponse.fromEntity(todoRepository.save(todoEntity));
	}
	
	//부분삭제
	@Override
	public void deleteById(Integer id) {
		todoRepository.deleteById(id);
	}
	//전체삭제
	@Override
	public void deleteAll() {
		todoRepository.deleteAll();
	}
	

}
