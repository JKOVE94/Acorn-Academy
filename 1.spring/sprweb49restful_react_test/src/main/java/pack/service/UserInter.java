package pack.service;

import java.util.List;
import pack.dto.UserDto;
import pack.form.UserForm;

public interface UserInter {

	//Like Auto Increment
	long findMaxNum();
	//유저가 입력한 id가 회원리스트에 있는지 체크
	long checkUser(String userid);

	//로그인 체크
	boolean checkLogin(long userno, String userid, String userpass);
	//유저 전체 정보 받기
	List<UserDto> getAllUsers();
	//유저 한명정보 받기
	UserDto getUser(long uid);
	//유저 등록
	void joinUser(UserForm form);
	//유저 정보 수정
	void updateUser(UserForm form);
	//유저 삭제
	void deleteUser(long uid);
}
