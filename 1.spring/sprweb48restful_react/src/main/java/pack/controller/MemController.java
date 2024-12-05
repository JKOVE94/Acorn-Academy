package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemberDto;
import pack.repository.MemberDao;
/*
@Controller
public class MemController {


	@Autowired
	private MemberDao dao;
	
	@GetMapping("/members")
	public String list(Model model) {
		List<MemberDto> list = dao.getDataAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam("num")int num, @RequestParam("name")String name, @RequestParam("addr")String addr) {
		MemberDto fbean = new MemberDto();
		fbean.setNum(num);
		fbean.setName(name);
		fbean.setAddr(addr);
		dao.insert(fbean);
		return "redirect:/members";
	}
	
	@GetMapping("insertform")
	public String insertform() {
		return "insertform";
	}
*/
@RestController
public class MemController {
	
	@Autowired
	private MemberDao dao;
	
	@GetMapping("/members")
	public List<MemberDto> getAllMember(){
	return dao.getDataAll();		
	}
		
	@GetMapping("/members/{num}")
	public MemberDto getList(@PathVariable("num")int num){
		return dao.getData(num);
	}
	
	@PostMapping("/members")
	public Map<String,Object> addMember(@RequestBody MemberDto fbean) {
		dao.insert(fbean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		return map;
	}
	
	@PutMapping("/members/{num}")
	public Map<String,Object> updateMember(@PathVariable("num")int num,@RequestBody MemberDto fbean) {
		fbean.setNum(num);
		dao.update(fbean);	
		return Map.of("isSuccess", true);
	}
	
	@DeleteMapping("/members/{num}")
	public Map<String,Object> deleteMember(@PathVariable("num")int num) {
		dao.delete(num);
		return Map.of("isSuccess", true);
	}
	
}
