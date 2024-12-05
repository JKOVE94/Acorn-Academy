package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.UserDto;
import pack.form.UserForm;
import pack.service.UserInter;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserInter uinter;
	
	//로그인 시도
	@GetMapping("/login")
	public long login(UserForm form) {
		long userno = uinter.checkUser(form.getUserid());
		String userid = form.getUserid();
		String userpass = form.getUserpass();
		if(userno>0) {
			if(uinter.checkLogin(userno, userid, userpass)) {
				return userno; //로그인에 성공힐 시 유저 번호 전송
			}
			else return -1; // 실패시 음수
		}
		else return -1; //실패시 음수
	}
	
	//유저 정보 가져오기
	@GetMapping("/info")
	public UserDto getInfo(long userno) {
		UserDto dto = null;
		try {
			dto = uinter.getUser(userno);			
		}
		catch(Exception e) {
			System.out.println("getInfo err : "+e);
			return null;
		}
		return dto;
	}
	
	//회원가입
	@PostMapping("/singin")
	public String signin(UserForm form) {
		try {
			uinter.joinUser(form);			
		}catch(Exception e) {
			return "failure";
		}
		return "success";
	}
}
