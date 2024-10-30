package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("jikwonlist2")
	public String jikwonlist2(Model model) {
		model.addAttribute("jikwons", jikwonService.getJikwonHighPay());
		return "jikwonlist";
	}
	
	@GetMapping("jikwonlist3")
	public String jikwonlist3(@RequestParam("busername")String busername, Model model) {
		model.addAttribute("jikwons", jikwonService.getAllBuserName(busername));
		return "jikwonlist";
	}
	@GetMapping("jikwonlist4")
	public String jikwonlist4(Model model) {
		model.addAttribute("jikwons", jikwonService.getTopPaidJikwon());
		return "jikwonlist";
	}
	
	
}
