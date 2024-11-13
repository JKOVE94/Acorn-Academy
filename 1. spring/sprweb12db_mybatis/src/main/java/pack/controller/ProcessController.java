package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class ProcessController {

	@Autowired
	private DataDao dataDao;
	
	@GetMapping("dbtest")
	public String showProcess(Model model) {
		List<SangpumDto> list = dataDao.getDataAll();
		model.addAttribute("list", list);
		return "show";
	}
	
	@GetMapping("search")
	public String searchProcess(FormBean bean, Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>) dataDao.getDataSearch(bean);
		model.addAttribute("list", list);
		return "show";
	}
}
