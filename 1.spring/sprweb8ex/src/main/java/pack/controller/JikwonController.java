package pack.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.JikwonDaoInter;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	
	private String[] level = {"","사원", "대리", "과장", "부장", "이사"};
	List<String> levelList = Arrays.asList(level);
	
	@Autowired
	JikwonDaoInter jikwonDaoInter;

	@PostMapping("controller")
	public String jikwon(Model model, @RequestParam("level")String level) {
		model.addAttribute("jiklevel", level);
		
		ArrayList<JikwonDto> list=null;
		if(levelList.contains(level)) {
			list = jikwonDaoInter.getJik(level);			
			model.addAttribute("data", list);
			model.addAttribute("msg", null);
		}
		else {
			model.addAttribute("data", list);
			model.addAttribute("msg","잘못 입력하셨습니다. 다시 입력해주세요");
		}
		
		return "show";
	}
}
