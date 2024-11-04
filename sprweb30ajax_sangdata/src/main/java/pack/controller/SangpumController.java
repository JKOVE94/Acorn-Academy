package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataProcess;
import pack.model.SangdataDto;

@Controller
public class SangpumController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("sangpumlist")
	public String sanglist() {
		return "sanglist";		
	}
	
	@ResponseBody
	@GetMapping("sang")
	public List<SangdataDto> getSangpumlist() {
		return dataProcess.getAllSang();		
	}
	@ResponseBody
	@PostMapping("sangadd")
	public List<SangdataDto> addSangpumlist(SangdataForm form) {
		dataProcess.addSang(form);
		return dataProcess.getAllSang();		
	}
}
