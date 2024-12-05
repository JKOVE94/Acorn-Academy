package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pack.model.DataDaoInter;
import pack.model.JikwonDto;

@Controller
public class LoginController {

	@Autowired
	private DataDaoInter daoInter;
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String loginProcess(@RequestParam("no")String no, @RequestParam("name")String name, HttpSession session) {
		JikwonDto dto = daoInter.jikwonLogin(no);
		
		if(dto!=null) {
			String returnName= dto.getJikwonname();
			if(returnName.equals(name)) { //db에 저장된 직원명과 사용자가 입력한 이름 비교
				session.setAttribute("name", returnName);
			}
		}
		return "redirect:/jikwonlist";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		return "redirect:/";
	}
}
