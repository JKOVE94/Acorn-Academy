package pack.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pack.model.TodoResponse;
import pack.model.TodoService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoController {
	
	private final TodoService service;
	
	public TodoController(TodoService service) {
		this.service=service;
	}
	
	@GetMapping
	public ResponseEntity<List<TodoResponse>> readAll(){
		List<TodoResponse> list = service.searchAll();
		System.out.println("selectAll : "+ResponseEntity.ok(list));
		return ResponseEntity.ok(list);
	}
	@GetMapping("{id}")
	public ResponseEntity<TodoResponse> readOne(@PathVariable("id")Integer id){
		TodoResponse response = service.serchById(id);
		System.out.println("select part : "+ResponseEntity.ok(response));
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request){
		//ResponseEntity : 반환값에 상태코드와 응답메세지를 주고싶을 때 사용
		//응답을 보낼 때 헤더 및 상태코드를 직접 다룰 때 사용
		//ResponseEntity.ok(), ResponseEntity.badRequest().build(), ResponseEntity.created()...
		
		if(ObjectUtils.isEmpty(request.getTitle())) return ResponseEntity.badRequest().build(); //에러 확인 후 에러 코드를 반환
		if(ObjectUtils.isEmpty(request.getOrder())) request.setOrder(0); //에러 확인 후 기본값 제공
		if(ObjectUtils.isEmpty(request.getCompleted())) request.setCompleted(false); //에러 확인 후 기본값 제공
		
		TodoResponse res = service.add(request);
		System.out.println("insert : "+ResponseEntity.ok(res));
		return ResponseEntity.ok(res);
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<TodoResponse> update(@PathVariable("id")Integer id, @RequestBody TodoRequest request){
		
		System.out.println("id: "+id+" title :"+request.getTitle()+" Order : "+request.getOrder()+" completed : "+request.getCompleted());
		
		if(ObjectUtils.isEmpty(request.getTitle())) return ResponseEntity.badRequest().build(); //에러 확인 후 에러 코드를 반환
		if(ObjectUtils.isEmpty(request.getOrder())) request.setOrder(0); //에러 확인 후 기본값 제공
		if(ObjectUtils.isEmpty(request.getCompleted())) request.setCompleted(false); //에러 확인 후 기본값 제공
		
		TodoResponse res = service.updateById(id, request);
		System.out.println("update : "+ResponseEntity.ok(res));
		return ResponseEntity.ok(res);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteOne(@PathVariable("id")Integer id){
		service.deleteById(id);
		System.out.println("DeleteOne : "+ResponseEntity.ok().build());
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		service.deleteAll();
		System.out.println("DeleteAll : "+ResponseEntity.ok().build());
		return ResponseEntity.ok().build();
	}
}
