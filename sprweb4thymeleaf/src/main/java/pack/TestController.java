package pack;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping(path = "thymeleaf_test")
	public String sijak(Model model) {
		model.addAttribute("msg","타임리프 만세");
		model.addAttribute("msg2","tom");
		
		//DTO 자료 출력
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("ks10");
		sangpum.setSang("핸드 크림");
		sangpum.setPrice("5000");
		
		model.addAttribute("sangpum",sangpum);
		
		//List 자료 출력
		ArrayList<Sangpum> list = new ArrayList();
		list.add(sangpum);
		
		Sangpum sangpum2 = new Sangpum();
		sangpum2.setCode("ks20");
		sangpum2.setSang("종이컵");
		sangpum2.setPrice("1000");
		list.add(sangpum2);

		model.addAttribute("list",list);
		
		return "list"; // /templates/list.html
	}
}
