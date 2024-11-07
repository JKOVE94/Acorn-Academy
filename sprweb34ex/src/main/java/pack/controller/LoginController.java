package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.model.DataProcess;

@Controller
public class LoginController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("damdanggogek")
	public String damdang(HttpServletRequest req, HttpServletResponse resp) {
		return "damdanggogek";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
}
