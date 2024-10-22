package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;

@Controller
public class ListController {
	
	@Autowired
	private DataDao dataDao;

	@GetMapping("testdb")
	public String listProcess(Model model) {
		model.addAttribute("datas", dataDao.getDataAll());
		return "list";
	}
}
