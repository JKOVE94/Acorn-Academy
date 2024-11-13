package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoProcess;

@Controller
public class DetailController {
	
	@Autowired
	private BoardDaoProcess daoProcess;
	
	@GetMapping("detail")
	public String detail(Model model, @RequestParam("num")int num, @RequestParam("page")int page) {
		//조회수 증가
		daoProcess.updateReadcnt(num);
		
		//데이터 가져오기
		
		model.addAttribute("data", daoProcess.detail(num));
		model.addAttribute("page", page);
		return "detail";
	}
}
