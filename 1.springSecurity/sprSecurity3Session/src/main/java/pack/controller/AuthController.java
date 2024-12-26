package pack.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	
	public AuthController(AuthenticationManager authenticationManager){
		this.authenticationManager = authenticationManager;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String performLogin(@RequestParam("sabun")String sabun, @RequestParam("irum")String irum, Model model) {
		
		try {
			//2개의 파라미터 매개변수를 기반으로 인증 토큰을 생성 
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(sabun, irum);
			
			// 인증 매니저로 인증 시도
			Authentication authentication = authenticationManager.authenticate(token);
			// CustomUserDetailService.loadUserByUsername() 를 호출하여 사용자 정보를 얻음
			
			//인증 성공 시,SecurityContextHolder에 인증 객체가 저장 
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			return "redirect:/auth/success";
		} catch (AuthenticationException e) {
			model.addAttribute("error", e);
			return "login";
		}
	}
	
	@GetMapping("/success")
	public String success(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("username", authentication.getName());
		return "success";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/auth/login";
	}
	
	@GetMapping("/gugu")
	public String gugu() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || !authentication.isAuthenticated()) {
			return "redirect:/auth/login";
		}
		return "gugu";			
	}
	
	@PostMapping("/gugu")
	public String gugudan(@RequestParam("num")int num, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || !authentication.isAuthenticated()) {
			return "redirect:/auth/login";
		}
		model.addAttribute("num", num);
		return "gugu";			
	}
	
	
	
}
