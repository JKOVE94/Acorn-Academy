package pack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.dto.UserDto;
import pack.entity.User;
import pack.form.UserForm;
import pack.repository.UserRepository;

@Service
public class UserService implements UserInter{

	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	public long findMaxNum() {
		return uRepository.findMaxUserNo()+1;
	}
	
	//유저가 입력한 id가 회원리스트에 있는지 체크
	@Autowired
	public long checkUser(String userid) {
		List<User> list = uRepository.findAll();
		for(User u : list) {
			if (u.getUserid().equals(userid)) {
				return u.getUserno();
			}
		}
		return -1;
	}
	
	//로그인 체크
	@Autowired
	public boolean checkLogin(long userno, String userid, String userpass) {
		User user = uRepository.findById(userno).get();
		if(user.getUserid().equals(userid) && user.getUserpass().equals(userpass)) return true;
		else return false;
	}

	//유저 전체 정보 받기
	@Autowired
	public List<UserDto> getAllUsers() {
		return uRepository.findAll().stream()
		.map(UserDto :: fromEntity)
		.collect(Collectors.toList());
	}
	
	//유저 한명정보 받기
	@Autowired
	public UserDto getUser(long userno) {
		return UserDto.fromEntity(uRepository.findById(userno).get());
	}
	
	//유저 등록
	@Autowired
	public void joinUser(UserForm form) {
		User user = UserForm.toEntity(form);
		user.setUserno(findMaxNum());
		uRepository.save(user);
	}
	
	//유저 정보 수정
	@Autowired
	public void updateUser(UserForm form) {
		User user = uRepository.findById(form.getUserno()).get();
		user.setUsername(form.getUsername());
		user.setUserheight(form.getUserheight());
		user.setUserweight(form.getUserweight());
	}
	
	//유저 삭제
	@Autowired
	public void deleteUser(long uid) {
		uRepository.deleteById(uid);
	}
}
