package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.DataProcess;
import pack.model.MemDto;

@Controller
@RequestMapping(value="/members")
public class MemViewController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list() {
		return "list";
	}
	
	@GetMapping("/new")
	public String insert() {
		return "insert";
	}
	
	@GetMapping("/update/{num}")
	public String updateProcess(@PathVariable("num")int num, Model model) {
		MemDto dto = dataProcess.getMemberByNum(num);
		model.addAttribute("data", dto);
		return "update";
	}
}
