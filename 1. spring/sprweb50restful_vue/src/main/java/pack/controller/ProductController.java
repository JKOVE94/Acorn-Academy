package pack.controller;

import java.util.List;

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


import pack.dto.ProductDto;
import pack.repository.ProductProcess;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductProcess process;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAll(){
		List<ProductDto> products = process.getAll();
		return ResponseEntity.ok(products); //200
	}
	@GetMapping("/{code}")
	public ResponseEntity<ProductDto> getOne(@PathVariable("code")String code){
		ProductDto data = process.getData(code);
		if(data != null) return ResponseEntity.ok(data);
		else return ResponseEntity.notFound().build(); //404
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody ProductDto fbean){
		try {
			int result = process.insert(fbean);
			if(result>0) return ResponseEntity.ok("입력 성공");
			else throw new Exception("입력하신 데이터에 문제가 있습니다.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("입력 실패. 오류는 : "+e);
		}
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody ProductDto fbean){
		try {
			int result = process.update(fbean);
			if(result>0) return ResponseEntity.ok("수정 성공");
			else throw new Exception("입력하신 데이터에 문제가 있습니다.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("수정 실패. 오류는 : "+e);
		}
	}
	@DeleteMapping("/{code}")
	public ResponseEntity<String> delete(@PathVariable("code")String code){
		try {
			int result = process.delete(code);
			if(result>0) return ResponseEntity.ok("삭제 성공");
			else throw new Exception("찾으시는 데이터가 없습니다.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("삭제 실패. 오류는 : "+e);
		}
	}
	
}
