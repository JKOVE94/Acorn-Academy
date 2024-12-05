package controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	//log 정보 출력용 : Logger - 진행 중 발생하는 문제점 추적, 운영상태 모니터링
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("login")
	public String submitCall(Model model) {
		
		return "redirect:http://localhost/login.html"; //redirect 방식
	}
	
	//전통적 방법
	/*
	@PostMapping("login")
	public String submit(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		System.out.println(id + " " + pwd); //초보자용
		logger.info(id + " " + pwd); // slf4j의 로그 레벨 (최대) trace > debug > info > warn > error (최소)

		String data="";
		if(id.equals("aa") && pwd.equals("11")) {
			data="로그인 성공";
		}
		else {
			data="로그인 실패";
		}
		model.addAttribute("data",data);
		
		return "result"; //redirect 방식
	}
	*/
	
	//Spring 어노테이션 사용
	@PostMapping("login")
	public String submit(
			@RequestParam(value = "id")String id, 
			@RequestParam(value = "pwd", defaultValue = "11")String pwd, 
			//request객체로 넘어온 모든것은 String type 이 된다. 그러나 @RequestParam 어노테이션을 사용하면 형변환을 쉽게 할 수 있다.  
			Model model) {
		logger.info(id + " " + pwd); // slf4j의 로그 레벨 (최대) trace > debug > info > warn > error (최소)

		String data="";
		if(id.equals("aa") && pwd.equals("11")) {
			data="로그인 성공";
		}
		else {
			data="로그인 실패";
		}
		model.addAttribute("data",data);
				
		return "result";
	}
	
}
