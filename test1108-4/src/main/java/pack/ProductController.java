package pack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("checkPrice")
	public String message(@RequestParam("name")String name, @RequestParam("price")long price) {
		String howmuch;
		if(price>=50000) howmuch="고가";
		else howmuch="저가";
		return "상품명 : "+name+", 가격: "+price+"원 ("+howmuch+")";
	}
}
