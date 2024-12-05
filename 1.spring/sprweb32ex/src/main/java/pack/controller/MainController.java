package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.dto.JikwonDto;
import pack.model.DataProcess;

@Controller
public class MainController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/jik")
	@ResponseBody
	public Map<String, Object> jikList(){
		List<String> jlist = dataProcess.getAllJik();
		Map<String, Object> jiklist = new HashMap<String, Object>();
		jiklist.put("jlist", jlist);
		return jiklist;
	}
	
	@GetMapping("/getlist")
	@ResponseBody
	public Map<String, Object> getList(@RequestParam("jikwonjik")String jikwonjik, @RequestParam("jikwonrating")String jikwonrating){
		List<Map<String,String>> alist = new ArrayList<Map<String,String>>();
		Map<String, String> jlist=null;
		for(JikwonDto d : dataProcess.getJikwonList(jikwonjik, jikwonrating)) {
			jlist = new HashMap<String, String>();
			jlist.put("no", String.valueOf(d.getJikwonno()));
			jlist.put("name", d.getJikwonname());
			jlist.put("jik", d.getJikwonjik());
			jlist.put("pay", String.valueOf(d.getJikwonpay()));
			jlist.put("rate", d.getJikwonrating());
			alist.add(jlist);
		}
		Map<String, Object> jiklist2 = new HashMap<String, Object>();
		jiklist2.put("datas", alist);
		
		return jiklist2;
	}
	

	@GetMapping("/bu")
	@ResponseBody
	public Map<String, Object> buList(){
		List<String> blist = dataProcess.getAllBuserName();
		Map<String, Object> buserlist = new HashMap<String, Object>();
		buserlist.put("jlist", blist);
		return buserlist;
	}
	
	@GetMapping("/getbulist")
	@ResponseBody
	public Map<String, Object> getbuList(@RequestParam("busername")String busername, @RequestParam("jikwonrating")String jikwonrating){
		List<Map<String,String>> alist = new ArrayList<Map<String,String>>();
		Map<String, String> blist=null;
		for(JikwonDto d : dataProcess.getJikwonListWithBuser(busername, jikwonrating)) {
			blist = new HashMap<String, String>();
			blist.put("no", String.valueOf(d.getJikwonno()));
			blist.put("name", d.getJikwonname());
			blist.put("jik", d.getJikwonjik());
			blist.put("pay", String.valueOf(d.getJikwonpay()));
			blist.put("rate", d.getJikwonrating());
			blist.put("buser", d.getBuser().getBusername());
			alist.add(blist);
		}
		Map<String, Object> bulist2 = new HashMap<String, Object>();
		bulist2.put("datas", alist);
		
		return bulist2;
	}
	
}
