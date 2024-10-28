package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Board;
import pack.model.BoardDaoProcess;

@Controller
public class UpdateController {

	@Autowired
	private BoardDaoProcess daoProcess;
	
	@GetMapping("update")
	public String updateForm(@RequestParam("num")int num, @RequestParam("page")int page, Model model) {
		//수정자료 읽기
		Board board = daoProcess.detail(num);
		
		model.addAttribute("data", board);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(Model model, BoardBean bean) {
		String result = daoProcess.insertAndUpdate(bean);
		if(result.equals("success")) {
			return "redirect:detail?num="+bean.getNum()+"&page="+bean.getPage();
		}
		else {
			model.addAttribute("msg", result);
			return "forward:/error";
		}
	}

}
