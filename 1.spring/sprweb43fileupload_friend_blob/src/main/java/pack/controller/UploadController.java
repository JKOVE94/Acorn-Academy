package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pack.service.Service;

@Controller
public class UploadController {

	@Autowired
	private Service service;
	
	@GetMapping("/insert")
	public String showInsertForm() {
		return "insert";
	}
	
	//RedirectAttributes : 리디렉션을 수행할 때 한 컨트롤러 메서드에서 다른 컨트롤러 메서드로 Attributes 를 전달하는데 이용되는 스프링 프레임워크의 인터페이스이다
	//addFlashAttribute() 는 세션에 저장되고 오직 다음 요청에서만 접근 가능하다. 주소창에 표기되지 않음으로 폐쇄적이다.
	//세션에 저장되어 사용된 뒤에 자동으로 삭제된다 - 1회용 (검증결과 성공실패 여부 같이 임시 사용에 사용) => redirect로 사용자에게 메세지 전달용으로 사용 가능
	@PostMapping("/insert")
	public String insertProcess(FriendForm form, @RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) {
		long filesizelimit = 1024 * 1024 * 2;
		if(!file.isEmpty() && file.getSize() > filesizelimit) { //파일 크기 제한 2MB미만 1024 * 1024 * 2
			redirectAttributes.addFlashAttribute("message", "파일 크기가 너무 큽니다. 2MB미만 크기의 파일을 선택해주세요.");
			return "redirect:/insert";
		}
		
		// MultipartFile에 포함된 메소드. 업로드된 MIME 타입을 반환하는데 사용
		if(!file.getContentType().startsWith("image/")) { //이미지 파일인지를 확인
			redirectAttributes.addFlashAttribute("message", "파일 타입이 맞지 않습니다. 이미지를 선택해주세요.");
			return "redirect:/insert";			
		}
		
		//insert 처리
		try {
			form.setSajin(file.getBytes());
			form.setImagetype(file.getContentType());
			service.saveFriend(form);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "파일저장 도중 에러가 발생했습니다. 원인은"+e);
			return "redirect:/insert";			
		}
		return "redirect:/list";
	}
	
}
