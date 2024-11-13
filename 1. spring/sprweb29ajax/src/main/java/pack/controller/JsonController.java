package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.Mymodel;


@Controller
public class JsonController {

	@Autowired
	private Mymodel mymodel;
	
	@GetMapping("list")
	@ResponseBody
	public Mymodel getJson(@RequestParam("name")String name) {
		mymodel.setName(name);
		mymodel.setSkills(new String[] {"자바 전문 개발", "웹 개발"});
		return mymodel;
	}
	
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJson2() {
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "한국인");
		data.put("age", "22");
		dataList.add(data);
		data = new HashMap<String, String>();
		data.put("name", "신기해");
		data.put("age", "26");
		dataList.add(data);
		data = new HashMap<String, String>();
		data.put("name", "이겨라");
		data.put("age", "28");
		dataList.add(data);
		
		Map<String,Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		return data2;
	}
	
}
