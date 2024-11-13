package pack.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pack.model.MemDto;
import pack.model.DataProcess;

@RestController
@RequestMapping("/api") //아래 모든 메소드의 엔드 포인트 경로에 /api를 기본경로(prefix)로 설정
public class MemController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/members") //전체자료 읽기
	public List<MemDto> list() {
		return dataProcess.getDataAll();
	}
	
	@PostMapping("/members") //전체자료 읽기
	public Map<String, Object> insert(MemBean bean) {
		dataProcess.insertData(bean);
		return Map.of("isSucess",true);
	}
	
	@PutMapping("/members")
	public Map<String, Object> updateProcess(@RequestBody MemBean bean) {
		dataProcess.updateData(bean);
		return Map.of("isSuccess", true);
	}
	
	@DeleteMapping("/members/{num}")
	public Map<String, Object> deleteProcess(@PathVariable("num")int num){
		dataProcess.deleteData(num);
		return Map.of("isSucess",true);
	}
}
