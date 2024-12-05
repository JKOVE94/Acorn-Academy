package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "java") <- 이런식으로 입력하면 하부 컨트롤러에서는 해당 URI를 생략하고 입력 할 수 있다. => java/korea -> korea
public class TestController3 {

	@GetMapping(value = {"java/korea","nice"}) // 여러 URI를 같은 방법으로 이동하길 원한다면 배열 형식으로 지정하면 된다.
	public String ghi(Model model) {
		model.addAttribute("msg","java/korea 요청 처리");
		return "list";
	}
	
	@GetMapping(value = {"java/good","ok"})
	public String ghi2(Model model) {
		model.addAttribute("msg","java/good 요청 처리");
		return "list";
	}
}
