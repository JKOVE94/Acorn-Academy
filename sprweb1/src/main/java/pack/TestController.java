package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


// 인스턴스 생성, 클라이언트와 데이터 입출력을 제어하는 클래스에 적용
// 클라이언트의 요청을 처리한 후 지정된 view에 모델 객체를 넘겨주는 역할

/*
@Controller
//@ResponseBody //body에 해당 String을 출력해주는 어노테이션 || 자바 객체를 http 응답 본문 객체로 변환하여 클라이언트로 전송 || JSON으로 넘길 수 도 있다.
@RestController //Controller + ResponseBody => RESTful 웹 프로그래밍 즉 AJAX로 요청할때 사용하는 어노테이션
public class TestController{
	@RequestMapping("test1") //get과 post모두 처리
	public String abc() {
		System.out.println("abc처리");
		return "<h1>금요일이다~</h1>";
	}
}
*/

@Controller
public class TestController{
	
	@RequestMapping("test1") //get과 post모두 처리
	public ModelAndView abc() {
		System.out.println("abc처리");
		
		//모델을 다녀왔다 가정
		String result = "모델 반환 정보";
		//return null;
		
		//모델 반환 정보를 뷰(jsp)로 전달
		/*
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list"); // prefix{/WEB-INF/views/}   list suffix{.jsp}
		modelAndView.addObject("msg", result); // request.setAttribute("msg", result)
		return modelAndView; //forwarding 
		*/
		
		return new ModelAndView("list", "msg", result);
		
	}
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public ModelAndView abc2() {
		return new ModelAndView("list","msg","요청처리 성공2");
	}
	@GetMapping("test3") //GET 방식만 처리 -> @PostMapping : POST 방식만 처리
	public ModelAndView abc3() {
		return new ModelAndView("list","msg","요청 성공3");
	}
	
	@GetMapping("test4")
	public String abc4(Model model) {
		model.addAttribute("msg", "요청 성공4"); // 이 방법이 ModelAndView보다 선호하는 방법이다.
		return "list"; //view file명
	}
	@RequestMapping(value = "test5", method = RequestMethod.POST)
	public String abc5(Model model) {
		model.addAttribute("msg", "요청 성공5"); // 이 방법이 ModelAndView보다 선호하는 방법이다.
		return "list"; //view file명
	}
	@PostMapping("test6")
	public ModelAndView abc6() {
		return new ModelAndView("list","msg","요청 성공6");
	}
	@PostMapping("test7")
	public String abc7(Model model) {
		model.addAttribute("msg","요청 성공7");
		return "list";
	}
	@GetMapping("test8")
	@ResponseBody
	public String abc8() {
		String value = "일반 문자열-String, 자바객체, Map, JSON 등을 전달";
		return value;
	}
	@GetMapping("test8_1")
	@ResponseBody
	public DataVo abc8_1() {
		DataVo dataVo = new DataVo();
		dataVo.setCode(10);
		dataVo.setName("가을비");
		return dataVo;
	}
}