package pack;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/default")
	//Authentication : 현재 로그인한 사용자에 대한 정보를 가짐
	public void defaultAfterLogin(Authentication authentication, HttpServletResponse resp) throws IOException {
		for(GrantedAuthority authority : authentication.getAuthorities()) {
			String role = authority.getAuthority(); //특정 권한(role)을 문자열로 반
			System.out.println(role);
			if(role.equals("ROLE_ADMIN")) {
				resp.sendRedirect("/admin");
				return;
			}
			else if(role.equals("ROLE_USER")) {
				resp.sendRedirect("/user");
				return;
			}
			else if(role.equals("ROLE_JAMES")) {
				resp.sendRedirect("/james");
				return;
			}
		}
		resp.sendRedirect("/common");
	}
	
	@GetMapping("/admin")
	public String adminPage(Model model) {
		model.addAttribute("msg", "관리자 권한");
		return "common";
	}
	@GetMapping("/user")
	public String userPage(Model model) {
		model.addAttribute("msg", "일반 유저 권한");
		return "common";
	}
	@GetMapping("/james")
	public String jamesPage(Model model) {
		model.addAttribute("msg", "제임스 권한");
		return "common";
	}
	@GetMapping("/common")
	public String commonPage(Model model) {
		model.addAttribute("msg", "전체 공통 권한");
		return "common";
	}
	
	
	
}
