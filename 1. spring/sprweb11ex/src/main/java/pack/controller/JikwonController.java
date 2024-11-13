package pack.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.JikwonDto;
import pack.model.JikwonInter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "controller")
public class JikwonController {

	@Autowired
	private JikwonInter jikwonInter;
	
	//직급 리스트
	private String[] level = {"","사원","대리","부장","과장","이사"};
	private List<String> levelList = Arrays.asList(level);
	
	//부서 리스트
	private String[] depart = {"","총무부","영업부","전산부","관리부"};
	private List<String> departList = Arrays.asList(depart);
	
	@RequestMapping(value = "findLevel", method=RequestMethod.POST)
	public String getJikwonL(@RequestParam("level")String level, Model model) {
		ArrayList<JikwonDto> list=null;
		//유저가 입력한 값이 직급 리스트에 있는지 확인
		if(levelList.contains(level)) {
			list = (ArrayList<JikwonDto>)jikwonInter.findJikwonL(level);
			model.addAttribute("data", list);
			model.addAttribute("msg", null);
			model.addAttribute("display", level);
		}
		else {
			model.addAttribute("data", list);
			model.addAttribute("msg", "잘못 입력하셨습니다");
		}
		return "show";
	}
	
	@RequestMapping(value = "findDepart", method=RequestMethod.POST)
	public String getjikwonD(@RequestParam("depart")String depart, Model model) {
		ArrayList<JikwonDto> list=null;
		//유저가 입력한 값이 부서 리스트에 있는지 확인
		if(departList.contains(depart)) {
			list = (ArrayList<JikwonDto>)jikwonInter.findJikwonD(depart);
			model.addAttribute("data", list);
			model.addAttribute("msg", null);
			model.addAttribute("display", depart);
		}
		else {
			model.addAttribute("data", list);
			model.addAttribute("msg", "잘못 입력하셨습니다");	
		}
		return "show";
	}
	
	
}
