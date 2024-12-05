package pack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "thleaf")
public class TestController {
	
	@GetMapping("/ex1")
	public String abc1(Model model) {
		ItemDto dto = new ItemDto();
		dto.setId("ks1");
		dto.setName("마우스");
		dto.setPrice(5000);
		dto.setRegdate(LocalDate.now());
		
		model.addAttribute("dto",dto);
		return "show1"; //forwarding
		//retrun "redirect:http://localhost/something.html <- redirect
	}
	
	@GetMapping("/ex2")
	public ModelAndView abc2() {
		ModelAndView andView = new ModelAndView("show2");
		List<ItemDto> list = new ArrayList<ItemDto>();
		
		for(int i=1; i<=3; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks"+i);
			dto.setName("신상 "+i);
			dto.setPrice(5000*i);
			dto.setRegdate(LocalDate.now());
			list.add(dto);
		}
		
		andView.addObject("datas", list);
		return andView;
	}
	
	@GetMapping("/ex3")
	public String abc3(Model model) {
		List<ItemDto> list = new ArrayList<ItemDto>();
		
		for(int i=1; i<=5; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks"+i);
			dto.setName("신상품"+i);
			
			list.add(dto);
		}
		
		model.addAttribute("dtos", list);
		return "show3";
	}
	
	@GetMapping("/ex4")
	public String abc4(Model model, @RequestParam("param1")String var1, @RequestParam("param2")String var2) {
		
		model.addAttribute("arg1", var1);
		model.addAttribute("arg2", var2);
		return "show4";
	}
	
	@GetMapping("/ex5") //레이아웃 설정 연습
	public String abc5() {
		return "show5";
	}
	
	@GetMapping("/ex5-1") //레이아웃 설정 연습
	public String abc5other() {
		return "show5-1";
	}
	
	@GetMapping("/ex6") //문서의 삽입 연습
	public String abc6() {
		return "show6";
	}

}
