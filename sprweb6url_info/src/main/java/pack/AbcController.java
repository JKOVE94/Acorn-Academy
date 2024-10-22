package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AbcController {

	@GetMapping(value = "kbs/login", params= "type=admin")
	public String aa(Model model) {
		model.addAttribute("msg","관리자");
		return "list";
	}
	
	@GetMapping(value = "kbs/login", params= "type=user")
	public String bb(Model model) {
		model.addAttribute("msg","일반 회원");
		return "list";
	}
	
	@GetMapping(value = "kbs/login", params= "!type")
	public String cc(Model model) {
		model.addAttribute("msg","type 값이 없네요");
		return "list";
	}
	
	
	@PostMapping(value = "kbs/login")
	public String dd(Model model, @RequestParam("type") String type) {
		model.addAttribute("msg","type : "+type);
		return "list";
	}
	
	//주소의 /를 기준으로 정보를 담을때는 아래와 같이 설정한다.
	//{} 안의 값은 변수 지정이며 임의로 지정할 수 있다.
//	@GetMapping(value = "ent/{ent}/singer/{singer}")
	@GetMapping(value = "ent/{ent}/singer/{singer}")
	public String aa(Model model, @RequestParam("title")String title, @PathVariable("ent") String ent, @PathVariable("singer") String singer) {
		
		String ss = "소속사 : " + ent + ", 가수 : " + singer + ", 히트곡 : "+ title;

		model.addAttribute("msg",ss);
		return "list";
	}
	
}
