package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@GetMapping("login")
	public String login(HttpSession session) {
		if(session.getAttribute("idKey") == null) {
			return "redirect:/login.html";
			
		}else {
			return "redirect:/buserlist";
		}
	}
	@PostMapping("login")
	public String login(@RequestParam("id")String id, @RequestParam("pwd") String pwd, HttpSession session) {
		if(id.equals("aa") && pwd.equals("11")) {
			session.setAttribute("idKey", id);
			return "redirect:/buserlist";
		}
		else {			
			return "redirect:/login.html";
		}
	}
	//@GetMapping("logout")
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		//session.invalidate(); 전체 세션 삭제 => 크게 권하지 안는다.
		session.removeAttribute("idKey");
		return "redirect:/";
	}
	
}
