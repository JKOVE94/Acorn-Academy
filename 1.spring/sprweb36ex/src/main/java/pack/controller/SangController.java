package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pack.model.DataProcess;
import pack.model.SangDto;

@RestController
public class SangController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("sangpum")
	public List<SangDto> getSangs(){
		return dataProcess.getAllSang();
	}
	@GetMapping("sangpum/{code}")
	public SangDto getSangs(@PathVariable("code")int code){
		return dataProcess.getSang(code);
	}
	
	@PostMapping("sangpum")
	public String insSang(@RequestBody SangForm form){
		dataProcess.insert(form);
		return "입력 완료";
	}
	
	@PutMapping("sangpum")
	public String upSang(@RequestBody SangForm form){
		dataProcess.update(form);
		return "업데이트 완료";
	}
	
	@DeleteMapping("sangpum/{code}")
	public String delSang(@PathVariable("code")int code){
		System.out.println("code : " + code);
		dataProcess.delete(code);
		return "삭제 완료";
	}
	
}
