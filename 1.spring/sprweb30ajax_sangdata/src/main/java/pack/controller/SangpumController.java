package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.dto.SangpumDto;
import pack.model.DataProcess;

@Controller
public class SangpumController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("sangpums")
	@ResponseBody
	public Map<String, Object> sangpumProcess(){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		for(SangpumDto s : dataProcess.getAllSang()) {
			data = new HashMap<String, String>();
			data.put("code", String.valueOf(s.getCode()));
			data.put("sang", s.getSang());
			data.put("su", String.valueOf(s.getSu()));
			data.put("dan", String.valueOf(s.getDan()));
			list.add(data);
		}
		System.out.println(list);
		
		Map<String, Object> sanglist = new HashMap<String, Object>();
		sanglist.put("datas", list);
		return sanglist;
	}
	
	
	@GetMapping("sangpumlist")
	public String sanglist() {
		return "sanglist";		
	}
	
	@ResponseBody
	@GetMapping("sang")
	public List<SangpumDto> getSangpumlist() {
		return dataProcess.getAllSang();		
	}
	@ResponseBody
	@PostMapping("sangadd")
	public List<SangpumDto> addSangpumlist(@RequestBody SangdataForm form) {
		dataProcess.addSang(form);
		return dataProcess.getAllSang();		
	}
}
