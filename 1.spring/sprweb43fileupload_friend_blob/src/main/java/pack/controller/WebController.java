package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.dto.FriendDto;
import pack.entity.Friend;
import pack.service.Service;

@Controller
public class WebController {

	@Autowired
	private Service service;

	@GetMapping("/")
	public String startPage() {
		return "start";
	}

	@GetMapping("list")
	public String listPage(Model model) {
		List<FriendDto> friends = service.findAll();
		model.addAttribute("friends", friends);
		return "list";
	}

	// Spring Security - login function trial
	@GetMapping("login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("login")
	public String loginProcess() {
		return "login";
	}
}
