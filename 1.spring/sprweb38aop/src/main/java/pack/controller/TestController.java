package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.MymodelInter;

@Controller
public class TestController {

	@Autowired
	@Qualifier("MymodelImpl")
	private MymodelInter mInter;
	
	@GetMapping("aoptest")
	public String aoptest(Model model) {
		
		String result1 = mInter.processMsg();
		String result2 = mInter.businessMsg();
		
		model.addAttribute("data1",result1);
		model.addAttribute("data2",result2);
		return "list";
	}
	
	
}
