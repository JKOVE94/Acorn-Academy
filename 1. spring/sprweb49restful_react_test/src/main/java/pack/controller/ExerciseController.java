package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.ExerciseDto;
import pack.service.ExerciseInter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ExerciseController {

	@Autowired
	private ExerciseInter inter;
	
	@GetMapping("/exercises")
	public List<ExerciseDto> getAllinfo(){
		return inter.getAllList();
	}
	
	@GetMapping("/exercises/{id}")
	public ExerciseDto getAllinfo(@PathVariable("id")long id){
		return inter.getOne(id);
	}
	
	@PostMapping("/exercises")
	public String insert(@RequestBody ExerciseForm form) {
		inter.insertAndUpdate(form);
		return "잘 등록되었음";
	}
	
	@PutMapping("/exercises/{id}")
	public String update(@PathVariable("id")long id,@RequestBody ExerciseForm form) {
		form.setId(id);
		inter.insertAndUpdate(form);
		return "잘 수정되었음";
	}
	
	@DeleteMapping("/exercises/{id}")
	public String delete(@PathVariable("id")long id) {
		inter.delete(id);
		return "잘 삭제되었음";
	}
	
	
	
}
