package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.form.MemberForm;
import pack.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService memberInterface;
	
	@GetMapping("mlist")
	public String memList(Model model) {
		memberInterface.getAllMember(model);
		return "member/mlist";
	}
	
	@GetMapping("minsert")
	public String memInsertForm() {
		return "member/minsert";
	}
	@PostMapping("minsert")
	public String memInsertProcess(MemberForm form) {
		memberInterface.insert(form);
		return "redirect:/member/mlist";		
	}
	@GetMapping("update")
	public String memUpdateForm(@RequestParam("num")Long num,  Model model) {
		memberInterface.getData(num, model);
		return "member/mupdate";
	}
	
	@PostMapping("update")
	public String memUpdateProcess(MemberForm form) {
//		memberInterface.update(form); <- 동일 엔티티인지 확인하는 작업없이 바로 수정 (@Transactional X)
		memberInterface.update2(form);
		return "redirect:/member/mlist";		
	}
	
	@GetMapping("delete")
	public String memDelete(@RequestParam("num")Long num) {
		memberInterface.delete(num);
		return "redirect:/member/mlist";
	}
	
}
