package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.SangpumDao;
import pack.model.SangpumEntity;

@Controller
public class TestController {

	@Autowired
	private SangpumDao sangpumDao;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("testdb")
	public String listProcess(Model model) {
		ArrayList<SangpumEntity> list = (ArrayList<SangpumEntity>) sangpumDao.getDataAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("search")
	public String searchProcess(Model model, @RequestParam("searchValue")String svalue) {
		//ArrayList<SangpumEntity> list = (ArrayList<SangpumEntity>) sangpumDao.getDataSearch(svalue);
		ArrayList<SangpumEntity> list = (ArrayList<SangpumEntity>) sangpumDao.getDataSearch2(svalue);
		model.addAttribute("list", list);
		return "list";
	}
	
}
