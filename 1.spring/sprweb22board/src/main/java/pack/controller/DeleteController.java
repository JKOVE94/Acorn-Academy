package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoProcess;

@Controller
public class DeleteController {

	@Autowired
	BoardDaoProcess daoProcess; 
	
	@GetMapping("delete")
	public String deleteProcess(@RequestParam("num")int num) {
		daoProcess.delete(num);
		return "redirect:list";
	}
}
