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
	public String updateProcess(Model model, BoardBean bean, @RequestParam("page")String page) {
		//비밀번호 확인 후 수정
		String pass = daoProcess.getPass(bean.getNum());
		
		if(bean.getPass().equals(pass)) {
			String result = daoProcess.insertAndUpdate(bean);
			if(result.equals("success")) {
				//상세보기로 돌아가기
				return "redirect:detail?num="+bean.getNum()+"&page="+page;
				
				//목록보기로 돌아가기
//				return "redirect:list?page="+bean.getPage();
			}
			else {
				model.addAttribute("page", page);
				model.addAttribute("msg", result);
				return "forward:/error";
			}	
		}
		else {
			model.addAttribute("page", page);
			model.addAttribute("msg", "비밀번호가 일치하지 않음");
			return "forward:/update_err";
		}
		
		
	}

}
