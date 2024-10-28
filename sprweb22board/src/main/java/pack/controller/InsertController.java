package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import pack.model.BoardDaoProcess;

@Controller
public class InsertController {

	@Autowired
	private BoardDaoProcess daoProcess;

	@GetMapping("insert")
	public String insertForm() {
		return "insform";
	}
	
	@PostMapping("insert")
	public String insertProcess(BoardBean bean, Model model) {
		
		//client ip 얻기
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String ip = req.getHeader("X-Forwarded-For");
		if(ip==null) ip = req.getRemoteAddr();
		System.out.println("ip :"+ip);
		
		//유저가 입력하지 않은 값중 자동으로 입력해야하는 값을 bean에 추가 / 나머지는 기본값 0
		bean.setNum(daoProcess.getMax()); //새 글번호
		bean.setBip(ip);
		bean.setBdate();
		bean.setGnum(bean.getNum());
		
		String result = daoProcess.insertAndUpdate(bean);
		if(result.equals("success")) return "redirect:list"; //추가 후 목록보기
		else {
			model.addAttribute("msg", result);
			return "forward:/error";
		}
	}
	
}
