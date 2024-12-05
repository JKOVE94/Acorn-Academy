package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.dto.JikwonDto;
import pack.model.DataProcess;

@Controller
public class DataController {

	@Autowired
	private DataProcess process;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("buserlist")
	public String buserProcess(Model model) {
		model.addAttribute("blist", process.buserList());
		return "list";
	}
	
	@GetMapping("jikwonlist")
	@ResponseBody
	public Map<String, Object> jikwonProcess(@RequestParam("buserno")int buserno) {
		List<Map<String, String>> jlist = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		for(JikwonDto j : process.jikwonList(buserno)) {
			data = new HashMap<String, String>();
			data.put("no", String.valueOf(j.getJikwonno()));
			data.put("name", j.getJikwonname());
			data.put("jik", j.getJikwonjik());
			jlist.add(data);
		}
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("datas", jlist);
		return datas;
	}
	
}
