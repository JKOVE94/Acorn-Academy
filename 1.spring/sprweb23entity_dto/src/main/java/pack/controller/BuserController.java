package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BuserDto;
import pack.model.DataProcess;

@Controller
public class BuserController {

	@Autowired
	private DataProcess dataProcess;

	@GetMapping("/")
	public String start(BuserBean bean) {
		return "index";
	}

	@GetMapping("list")
	public String listProcess(Model model) {
		ArrayList<BuserDto> dto = (ArrayList<BuserDto>) dataProcess.getDataAll();
		model.addAttribute("datas", dto);
		return "list";
	}

	@GetMapping("insert")
	public String insform() {
		return "insform";
	}

	@PostMapping("insert")
	public String insProcess(BuserBean bean, Model model) {
		String msg = dataProcess.insert(bean);
		if (msg.equals("success"))
			return "redirect:list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}

	@GetMapping("delete")
	public String delete(@RequestParam("buserno") int buserno, Model model) {
		String msg = dataProcess.delete(buserno);
		if (msg.equals("success"))
			return "redirect:list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}

	@GetMapping("update")
	public String update(Model model, @RequestParam("buserno") int buserno) {
		BuserDto dto = dataProcess.getById(buserno);
		model.addAttribute("dto", dto);
		return "upform";
	}
	
	@PostMapping("update")
	public String update(Model model, BuserBean bean) {
		String msg = dataProcess.update(bean);
		if (msg.equals("success"))
			return "redirect:list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
}
