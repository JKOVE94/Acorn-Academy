package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemDao;
import pack.model.MemDto;

@Controller
public class MemController {

	@Autowired
	private MemDao memDao;
	
	@GetMapping("/")
	public String mainPage() {
		return "index";
	}
	
	@GetMapping("/memlist")
	public String listProcess(Model model) {
		ArrayList<MemDto> list = (ArrayList<MemDto>) memDao.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("/insert")
	public String ins() {
		return "insert";
	}
	
	@PostMapping("/insert")
	public String ins(Model model, MemBean bean) {
		boolean b = memDao.insertData(bean);
		System.out.println(b);
		if(b) return "redirect:/memlist";
		else return "redirect:/error";
	}
	
	@GetMapping("/error")
	public String err() {
		return "error";
	}
	
	@GetMapping("/update")
	public String update(Model model, MemBean bean) {
		MemDto dto = memDao.getData(bean.getNum());
		model.addAttribute("dto", dto);
		return "update";
	}
	@PostMapping("/update")
	public String processUpdate(Model model, MemBean bean) {
		boolean b = memDao.updateData(bean);
		if(b) return "redirect:/memlist";
		else return "redirect:/error";
	}
	
	@GetMapping("/delete")
	public String deleteProcess(Model model, @RequestParam("num") String num) {
		boolean b = memDao.deleteData(num);
		if(b) return "redirect:/memlist";
		else return "redirect:/error";
	}
}
