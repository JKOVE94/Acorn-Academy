package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.model.DataDaoInter;
import pack.model.JikwonDto;

@Controller
public class JikwonController {

	@Autowired
	private DataDaoInter inter;
	
	@GetMapping("jikwonlist")
	public String jikProcess(Model model, HttpServletRequest req, HttpServletResponse resp) {
		List<JikwonDto> list = inter.getAllJik();
		model.addAttribute("list", list);
		return "show";
	}
	
}
