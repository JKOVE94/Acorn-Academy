package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;

@Controller
public class ListController {

	@Autowired
	private DataProcess process;
	
	@GetMapping("/")
	public String JikwonList(Model model) {
		model.addAttribute("list",process.jikwonBuserList());
		return "Jikwonbuser";
	}
	
	@GetMapping("damgogek")
	public String JikwonList(@RequestParam("jikwonno")int jikwonno , Model model) {
		model.addAttribute("list",process.jikwonGogekList(jikwonno));
		return "damgogek";
	}
}
