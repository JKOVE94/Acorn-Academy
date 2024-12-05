package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class InsertController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("insert")
	public String form() {
		return "insform";
	}
	@PostMapping("insert")
	public String submit(Model model, MemberBean bean) {
		memberDao.insData(bean); //입력에는 에러가 발생 할 수 있기 때문에 try, catch로 처리해주는것이 좋다.
		return "redirect:/show"; //추가후 목록 보기
	}
}
