package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/staff/user/list")
	public String userList() {
		return "user/list";
	}
	
	@GetMapping("/admin/user/manage")
	public String userManage() {
		return "user/manage";
	}
	
}
