package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataProcess;
import pack.model.GogekDto;
import pack.model.JikwonDto;

@Controller
public class ListController {

	@Autowired
	private DataProcess dataProcess;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("jikwonbuser")
	public String jikwonbuser(Model model) {
		List<JikwonDto> list = dataProcess.jikwonBuserList();
		model.addAttribute("list", list);
		return "jikwonbuser";
	}

	@GetMapping("jikwongogek")
	public String jikwongogek(Model model) {
		List<JikwonDto> list = dataProcess.jikwonGogekList();
		model.addAttribute("glist", list);
		return "jikwongogek";
	}
	
	//고객 담당 출력 (DTO)
	@GetMapping("gogekdamdang")
	public String gogekdamdang(Model model) {
		List<GogekDto> list = dataProcess.GogekDamdangList();
		model.addAttribute("dlist", list);
		return "gogekdamdang";
	}

	//고객 담당 출력 (String)
	@GetMapping("gogekdamdang2")
	public String gogekdamdang2(Model model) {
		List<String> list = dataProcess.GogekDamdangListStr();
		model.addAttribute("dlist", list);
		return "gogekdamdang2";
	}
}
