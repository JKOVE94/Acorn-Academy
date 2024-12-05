package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class ShowController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("show")
	public String showProcess(Model model) {
		ArrayList<MemberDto> list = (ArrayList<MemberDto>) memberDao.getMemberAll();
		model.addAttribute("list", list);
		return "list";
	}
}
