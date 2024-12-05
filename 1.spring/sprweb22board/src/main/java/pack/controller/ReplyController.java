package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import pack.model.Board;
import pack.model.BoardDaoProcess;

@Controller
public class ReplyController {
	
	@Autowired
	BoardDaoProcess daoProcess;

	@GetMapping("reply")
	public String replyPage(@RequestParam("num")int num, Model model) {
		//원글 정보
		model.addAttribute("data", daoProcess.detail(num));
		model.addAttribute("supernum", num);
		return "replyform";
		
	}
	@PostMapping("reply")
	public String replyProecess(@RequestParam("supernum")int num, BoardBean bean, Model model) {
		//client ip 얻기
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String ip = req.getHeader("X-Forwarded-For");
		if(ip==null) ip = req.getRemoteAddr();
		
		//유저가 입력하지 않은 값중 자동으로 입력해야하는 값을 bean에 추가 / 나머지는 기본값 0
		bean.setNum(daoProcess.getMax()); //새 글번호 (Like auto increment)
		bean.setBip(ip);
		bean.setBdate();
		bean.setGnum(daoProcess.getSuperGnum(num));
		bean.setOnum(1);
		bean.setNested(daoProcess.getSuperNested(num)+1);
		
		String result = daoProcess.reply(bean);
		if(result.equals("success")) return "redirect:list"; //추가 후 목록보기
		else {
			model.addAttribute("msg", result);
			return "forward:/error";
		}
	}
}
