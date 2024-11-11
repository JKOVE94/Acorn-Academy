package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	@GetMapping("check")
	public String abc(Model model, @RequestParam("name")String name, @RequestParam("age")int age) {
		String era;
		if(age>=20 && age<30) {
			era="이십대";
		}
		else if(age>=30 && age<40) {
			era="삼십대";
		}
		
		model.addAttribute("msg",name+"님은 "+age);
		return "result";
	}
}
