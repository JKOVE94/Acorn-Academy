package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.JikwonService;


@Controller
public class JikwonController {

	private final JikwonService jikwonService;
	
	@Autowired
	public JikwonController(JikwonService jikwonService) {
		this.jikwonService = jikwonService;
	}
	
	@GetMapping("/")
	public String list() {
		return "index";
	}
	
	@GetMapping("jikwonlist")
	public String jikwonlist(Model model) {
		model.addAttribute("jikwons", jikwonService.getJikwonData());
		return "jikwonlist";
	}
	
}
