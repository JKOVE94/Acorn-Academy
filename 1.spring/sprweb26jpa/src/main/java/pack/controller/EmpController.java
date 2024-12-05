package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.DeptDto;
import pack.dto.EmpDto;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@Controller
public class EmpController {

	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private DeptRepository deptRepository;
	
	@GetMapping("/employ/list")
	public String list(Model model) {
		List<Emp> list = empRepository.findAllByOrderByEmpnoAsc();
//		List<Emp> list = empRepository.getList(3000);
		model.addAttribute("list", list);
		return "/employ/elist";	
	}
	@GetMapping("/employ/dept")
	public String dept(Model model, @RequestParam("deptno")int deptno) {
		DeptDto dto = DeptDto.fromEntity(deptRepository.findById(deptno).get());
		model.addAttribute("dto", dto);
		return "/employ/dept";
		
	}
	
	
}
