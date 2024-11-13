package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test9")
public class TestController2 {
	@RequestMapping(method = RequestMethod.GET)
	public String def(Model model) {
		model.addAttribute("msg", "get 요청 성공");
		return "list";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg", "post 요청 성공");
		return "list";
	}
}
