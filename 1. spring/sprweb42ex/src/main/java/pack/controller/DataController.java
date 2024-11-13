package pack.controller;

import org.springframework.web.bind.annotation.RestController;

import pack.dto.SangDto;
import pack.model.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class DataController {

	@Autowired
	private Service service;
	
	@GetMapping("/getinfo/{code}")
	public Map<String, Object> getMethodName(@PathVariable("code")int code) {
		SangDto dto = service.getSang(code);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", dto);
		return map;
	}
	@GetMapping("/getinfo")
	public Map<String, Object> getAlldata(){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> map;
		for(SangDto d : service.getSangpumlist()) {
			map = new HashMap<String, String>();
			map.put("code", String.valueOf(d.getCode()));
			map.put("sang", d.getSang());
			map.put("su", String.valueOf(d.getSu()));
			map.put("dan", String.valueOf(d.getDan()));
			if(d.getSajinList().size()>0 && !d.getSajinList().isEmpty()) {
				map.put("path",d.getSajinList().get(0).getFilepath());
				map.put("about", d.getSajinList().get(0).getAbout());
			}
			else {
				map.put("path",null);
				map.put("about",null);
			}
			list.add(map);
		}
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("datas",list);
		return datas;
	}
}
