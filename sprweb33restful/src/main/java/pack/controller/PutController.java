package pack.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutController {

	@PutMapping(value= "/hiput")
	public String put1() { //용도는 update
		System.out.println("put 요청 처리");
		return "PUT 요청1 결과";
	}
	
	@PutMapping(value= "/hiput2")
	public String put2(@RequestBody PostdataBean bean) { 
		String name = bean.getName();
		String addr = bean.getAddr();
		System.out.println("put 요청2 처리");
		return "수정용 이름 :" + name + ", 수정용 주소 : " + addr;
	}
	
	@DeleteMapping(value = "/hidelete/{num}")
	public String delete(@PathVariable("num")String num) {
		System.out.println("DELETE 요청 처리"); //num을 들고 삭제 작업을 진행
		return "DELETE 대상 번호 : "+num;
	}
	
}
