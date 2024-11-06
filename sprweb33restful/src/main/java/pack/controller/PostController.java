package pack.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@PostMapping(value="/hipost")
	public String post1() {
		System.out.println("post 요청 접수 1");
		return "post 요청 1 결과 : ";
	}

	//form 태그로 전송한 자료를 수신
	@PostMapping(value="/hiform")
	public String post2(@RequestParam("name")String name, @RequestParam("addr")String addr) {
		System.out.println("post 요청 접수 2 : 파라미터 값으로 insert 진행...");
		return "post 요청 2 결과 : "+name+" "+addr;
	}
	
	//json 형식으로 전송한 자료 수신 - Map
	@PostMapping(value="/hiform2")
	// {name:이름, addr:주소}
	public String postJson(@RequestBody Map<String, String> postData) {
		String name = postData.get("name");
		String addr = postData.get("addr");
		System.out.println("post 요청 접수 3 : Json 형식으로 insert 진행...");
		return "post 요청 3 결과> 이름 : "+name+", 주소: "+addr;
	}
	
	//json 형식으로 전송한 자료 수신 - FormBean
		@PostMapping(value="/hiform3")
		// {name:이름, addr:주소}
		public String postForm(PostdataBean bean) {
			String name = bean.getName();
			String addr = bean.getAddr();
			System.out.println("post 요청 접수 4 : Json 형식으로 insert 진행...");
			return "post 요청 4 결과> 이름은 "+name+", 주소는 "+addr;
		}
}
