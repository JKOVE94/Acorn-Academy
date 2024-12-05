package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class DetailController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("detail")
	public String detailProcess(@RequestParam("id")String id, Model model) {
		MemberDto dto = memberDao.getMember(id);
		model.addAttribute("member",dto);
		return "detail";
	}
	
	//수정자료 화면에 띄우기
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String upform(@RequestParam("id")String id, Model model) {
		MemberDto dto = memberDao.getMember(id);
		model.addAttribute("member",dto);
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateProcess(MemberBean bean, Model model) {
		memberDao.upData(bean);
		return "redirect:detail?id="+bean.getId();
	}
	
	@GetMapping("delete")
	public String deleteProcess(@RequestParam("id")String id) {
		memberDao.delData(id);
		return "redirect:/show"; //삭제 후 목록보기
	}
}
