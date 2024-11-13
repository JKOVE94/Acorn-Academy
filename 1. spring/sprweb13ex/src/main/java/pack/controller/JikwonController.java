package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDaoInter;
import pack.model.JikwonDto;

@Controller
@RequestMapping("jikwon")
public class JikwonController {
	
	@Autowired
	private DataDaoInter dataDaoInter;
	
	@GetMapping("/all")
	public String getAllJik(Model model) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>) dataDaoInter.getAllJik();
		model.addAttribute("list", list);
		return "show";
	}
	
	@GetMapping("/search")
	public String getSearchJik(Model model, @RequestParam("jikwonname")String jikwonname) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>) dataDaoInter.getSearchJik(jikwonname);
		model.addAttribute("list", list);		
		return "show";
	}
}
