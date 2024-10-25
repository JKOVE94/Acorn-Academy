package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Board;
import pack.model.BoardDao;

@Controller
public class ListController {

	@Autowired
	private BoardDao dao;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		BoardBean bean = new BoardBean();
		ArrayList<Board> list = (ArrayList<Board>)dao.list();
		model.addAttribute("list", list);
		model.addAttribute("bean", bean);
		System.out.println(bean.getSearchName());
		return "list";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "insform";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertOk(Model model, BoardBean bean) {
		boolean b = dao.insert(bean);
		if(b) return "redirect:list"; //추가 후 목록보기
		else return "error";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(Model model, BoardBean bean) {
		ArrayList<Board> list = (ArrayList<Board>) dao.search(bean);
		model.addAttribute("list", list);
		model.addAttribute("bean", bean);
		System.out.println(bean.getSearchName());
		return "list";
		
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("num")String num) {
		Board board = dao.detail(num);
		model.addAttribute("board", board);
		return "detail";
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model, BoardBean bean) {
		boolean b = dao.update(bean);
		if(b) return "redirect:list"; //수정 후 목록보기
		else return "error";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delte(Model model, @RequestParam("num")String num) {
		boolean b = dao.Delete(num);
		if(b) return "redirect:list"; //수정 후 목록보기
		else return "error";
	}
	
	
}
