package pack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pack.repository.JikwonRepository;
import pack.service.BuserService;

@RestController
public class BuserController {

	@Autowired
	private BuserService service;

	@Autowired
	private JikwonRepository jikwonRepository;
	
	@GetMapping(value = "/api/{busername}")
	public Object getAllJikwon(@PathVariable("busername")String busername){
		return service.getJikwonWithBuserName(busername);
	}
}
