package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.dto.GogekDto;
import pack.dto.JikwonDto;
import pack.model.DataProcess;

@RestController
public class ListController {

	@Autowired
	private DataProcess process;
	
	@GetMapping("searchg")
	public Map<String, Object> findDamdang(@RequestParam("gogekno")String gogekno, @RequestParam("gogekname")String gogekname){
		Map<String, Object> map1 = new HashMap<String, Object>(); 
		if(process.getJikwon(gogekno, gogekname)!=null) {			
			map1.put("datas", process.getJikwon(gogekno, gogekname));
		}
		else {
			map1.put("datas", null);
		}
		
		return map1;
	}
	
	@GetMapping("searchb")
	public Map<String, Object> findBuser(@RequestParam("busername")String busername){
		Map<String,String> map1;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for(JikwonDto d : process.getJikwonsWithBusername(busername)) {
			System.out.println(d.getBusername());
			map1 = new HashMap<String, String>();
			map1.put("jiknum", String.valueOf(d.getJikwonno()));
			map1.put("jikname", d.getJikwonname());
			map1.put("jikbusertel", d.getBusertel());
			map1.put("jikbusername", d.getBusername());
			map1.put("jikjik", d.getJikwonjik());
			map1.put("jikdamgogek", String.valueOf(d.getGogekList().size()));
			list.add(map1);
		}
		Map<String, Object> map2 = new HashMap<String, Object>(); 
		map2.put("datas",list);
		return map2;
	}
	@GetMapping("logincheck")
	public Map<String, Object> verifyLogin(@RequestParam("jikwonno") String jikwonno, @RequestParam("jikwonname") String jikwonname, HttpServletRequest req){
		System.out.println(jikwonno+ " "+jikwonname);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = process.verifyLogin(jikwonno, jikwonname);
		HttpSession session = req.getSession();
		if(result) session.setAttribute("login", true);
		map.put("check", result);
		return map;
	}
	@GetMapping("delCookie")
	public void deleteCookie(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate();
        
        // JSESSIONID 쿠키 삭제
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/"); // 기본적으로 모든 경로에서 유효하도록 설정
        cookie.setMaxAge(0); // 쿠키 만료 시간을 0으로 설정하여 삭제
        cookie.setHttpOnly(true); // HttpOnly로 설정하여 JavaScript에서 접근 불가하도록
        cookie.setSecure(true); // 보안 프로토콜 사용 시 (https) 설정 (옵션)
        resp.addCookie(cookie);

	}
	
	@GetMapping("damgo")
	public Map<String, Object> getGogeks(@RequestParam("jikwonno")String jikwonno){
		Map<String,String> map1;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for(GogekDto g : process.getGogeksWithJikwonno(jikwonno)) {
			map1 = new HashMap<String, String>();
			map1.put("gnum", String.valueOf(g.getGogekno()));
			map1.put("gname", g.getGogekname());
			map1.put("gtel", g.getGogektel());
			map1.put("gjumin", g.getGogekjumin());
			list.add(map1);
		}
		Map<String, Object> map2 = new HashMap<String, Object>(); 
		map2.put("datas",list);
		return map2;
	}	
}
