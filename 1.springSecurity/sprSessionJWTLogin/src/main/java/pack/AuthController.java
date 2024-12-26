package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userid")String id, @RequestParam("password")String pwd, HttpServletResponse resp) {
		String validId = "ok";
		String validPwd = "111";
		
		if(id.equals(validId) && pwd.equals(validPwd)) {
			String token = jwtService.createToken(validId);
			Cookie cookie = new Cookie("jwt", token);
			cookie.setHttpOnly(true); //클라이언트에서 쿠키를 수정할 수 없음
			cookie.setPath("/");
			resp.addCookie(cookie);
			
			return "redirect:/success";
		}
		
		return "redirect:/login?error";
	}
	
	@GetMapping("success")
	public String success(HttpServletRequest req, Model model) {
		String userId =  getUserIdFromToken(req);
		if(userId == null) {
			return "redirect:/login";
		}
		model.addAttribute("userId", userId);
		return "success";
	}
	
	private String getUserIdFromToken(HttpServletRequest req) {
	    Cookie[] cookies = req.getCookies();
	    if (cookies != null) { // req.getCookies()가 null을 반환하는 경우를 대비한 null 체크
	        for (Cookie c : cookies) {
	            if (c.getName().equals("jwt")) {
	                String jwt = c.getValue();
	                try {
	                    String userid = jwtService.getUserIdFromToken(jwt);
	                    return userid; // 사용자 ID를 찾으면 즉시 반환 (이른 반환)
	                } catch (Exception e) {
	                    // JWT 파싱 또는 서명 검증 오류 처리
	                    System.err.println("JWT 처리 중 오류 발생: " + e.getMessage());
	                    // 필요에 따라 로그를 남기거나, 오류 응답을 전송하는 등의 처리
	                    return null; // 또는 예외를 다시 던지거나, 다른 방식으로 처리
	                }
	            }
	        }
	    }
	    return null; // "jwt" 쿠키를 찾지 못했거나, 예외가 발생한 경우 null 반환
	}
	
	@GetMapping("/logout")
    public String logout(HttpServletResponse resp) {
		Cookie cookie = new Cookie("jwt", null);
		cookie.setHttpOnly(true); //클라이언트에서 쿠키를 수정할 수 없음
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping("/gugu")
    public String gugu(HttpServletRequest req) {
        String user = getUserIdFromToken(req);
        if(user == null) {
            return "redirect:/login";
        }
        return "gugu";
    }
    
    @PostMapping("/gugu")
    public String gugu(@RequestParam(name="dan") int dan, HttpServletRequest req, Model model) {
        String user = getUserIdFromToken(req);
        if(user == null) {
            return "redirect:/login";
        }
        model.addAttribute("dan", dan);
        return "gugu";
    }
}
