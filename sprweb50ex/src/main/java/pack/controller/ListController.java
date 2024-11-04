package pack.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataProcess;

@Controller
public class ListController {

	@Autowired
	private DataProcess process;
	
	@GetMapping("searchg")
	@ResponseBody
	public Map<String, Object> findDamdang(@RequestParam("gogekno")String gogekno, @RequestParam("gogekname")String gogekname){
		Map<String, Object> map1 = new HashMap<String, Object>(); 
		map1.put("datas", process.getJikwon(gogekno, gogekname));
		return map1;
	}	
}
