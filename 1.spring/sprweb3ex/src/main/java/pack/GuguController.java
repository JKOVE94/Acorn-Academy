package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuguController {

	@Autowired
	GuguModelInter inter;
	
	@GetMapping("gugu")
	public String startGugu() {
		return "redirect:http://localhost/gugu.html";
	}
	@PostMapping("gugu")
	public String gugu(int num, Model model) {
		if(num>0) {
		model.addAttribute("data",inter.calcGugu(num));
		}
		else {
			model.addAttribute("data","잘못된 범위 입력");
		}
		return "gugu";
	}
}
