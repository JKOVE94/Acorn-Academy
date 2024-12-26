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

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import pack.util.JwtUtil;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil){
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String performLogin(@RequestParam("sabun")String sabun, @RequestParam("irum")String irum, Model model, HttpServletResponse resp) {
		
		try {
			//2개의 파라미터 매개변수를 기반으로 인증 토큰을 생성 
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(sabun, irum);
			
			// 인증 매니저로 인증 시도
			Authentication authentication = authenticationManager.authenticate(token);
			// CustomUserDetailService.loadUserByUsername() 를 호출하여 사용자 정보를 얻음
			
			String jwt = jwtUtil.generateToken(sabun);
			
			Cookie jwtCookie = new Cookie("JWT", jwt);
			jwtCookie.setHttpOnly(true);
			jwtCookie.setSecure(false); //HTTPS에서만 사용할 경우
			jwtCookie.setPath("/");
			jwtCookie.setMaxAge(60 * 60); //1시간 유효
			resp.addCookie(jwtCookie);
			
			return "redirect:/auth/success";
		} catch (AuthenticationException e) {
			model.addAttribute("error", e);
			return "login";
		}
	}
	
	@GetMapping("/success")
	public String success(Model model, Authentication authentication) {
		if(authentication!=null && authentication.isAuthenticated()) {
			model.addAttribute("username", authentication.getName());
			return "success";			
		}
		else return "redirect:/auth/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletResponse resp) {
		//JWT쿠키 제거
		Cookie cookie = new Cookie("JWT",null);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		
		//SecurityContext 초기화
		SecurityContextHolder.clearContext();
		
		return "redirect:/auth/login";
	}
	
	@GetMapping("/gugu")
	public String gugu(Authentication authentication, Model model) {
		if(authentication==null || !authentication.isAuthenticated()) {
			model.addAttribute("username", authentication.getName());
			return "redirect:/auth/login";
		}		
		return "gugu";			
	}
	
	@PostMapping("/gugu")
	public String gugudan(@RequestParam("num")int num, Model model, Authentication authentication) {
		if(authentication == null || !authentication.isAuthenticated()) {
			return "redirect:/auth/login";
		}
		model.addAttribute("num", num);
		return "gugu";			
	}
	
	
	
}
