package pack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
public class GetController {

	@GetMapping(value="/hello")
	public String sayHello() {
		System.out.println("요청 1 접수");
		return "Hello 안녕하세요";
	}
	
	@GetMapping(value="/hello/{info}")
	public String sayHello(@PathVariable("info")String info) {
		System.out.println("요청 2 접수"+info);
		return "반환 값 : " +info;
	}
	
	@GetMapping(value="/world") //물음표
	public String sayHello(@RequestParam("name")String irum, @RequestParam("age")String nai) {
		System.out.println("요청 3 접수");
		return "반환 값 : " +irum+ " " + nai;
	}
	
}
