package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("list")
	public String abc() {
		
		return "list";
	}
	
}
