package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FruitController {
	@GetMapping("/input")
    public String sendData(Model model, @RequestParam("sang")String sang, @RequestParam("price")int price, @RequestParam("quality")String quality, @RequestParam("su")int su){
		if(quality.equals("상")) price*=2;
		
		model.addAttribute("sang", sang);
		model.addAttribute("total", price*su);
		return "list";
    }
}
