package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataProcess;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

	@Autowired
	private DataProcess process;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		
		model.addAttribute("list", process.getAllJikwonWithGogek());
		return "list";
	}
	
	@GetMapping("gogek")
	public String gogek(@RequestParam("jikwonno")String jikwonno, @RequestParam("jikwonname")String jikwonname ,Model model) {
		model.addAttribute("jikwonname", jikwonname);
		model.addAttribute("list", process.getAllGogekWithJikwonno(jikwonno));
		return "gogek";
	}
	
}
