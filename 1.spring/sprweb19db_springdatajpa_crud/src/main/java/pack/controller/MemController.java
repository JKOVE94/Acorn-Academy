package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Mem;
import pack.model.DataProcess;

@Controller
public class MemController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("memlist")
	public String list(Model model) {
		ArrayList<Mem> list = (ArrayList<Mem>) dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String toInsert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String processInsert(MemBean bean, Model model) {
		String msg = dataProcess.insertData(bean);
		if(msg.equals("success")) return "redirect:/memlist"; //입력 후 목록보기
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	@GetMapping("update")
	public String toUpdate(@RequestParam("num")int num, Model model) {
		Mem mem = dataProcess.getMemberByNum(num);
		model.addAttribute("dto", mem);
		return "update";
	}
	
	@PostMapping("update")
	public String processUpdate(MemBean bean, Model model) {
		String msg = dataProcess.updateData(bean);
		if(msg.equals("success")) return "redirect:/memlist"; //수정 후 목록보기
		else {
			model.addAttribute("msg", msg);
			return "error";
		}		
	}
	
	@GetMapping("delete")
	public String processDelete(@RequestParam("num")int num, Model model) {
		String msg = dataProcess.deleteData(num);
		if(msg.equals("success")) return "redirect:/memlist"; //삭제 후 목록보기
		else {
			model.addAttribute("msg", msg);
			return "error";
		}				
	}
}
