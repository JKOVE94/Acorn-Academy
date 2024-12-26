package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pack.model.Jikwon;
import pack.model.JikwonRepository;

@Service
//사용자 인증시 사용자 정보를 로드
public class CustomUserDetailService implements UserDetailsService {

	//UserDetailsService : 사용자정보를 DB 또는 기타 저장소에서 로드 후 UserDetails 객체를 반환
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String sabun) throws UsernameNotFoundException {
		
		Long jikwonno = Long.parseLong(sabun); 
		Jikwon jikwon = jikwonRepository.findById(jikwonno).orElseThrow(() -> new UsernameNotFoundException(sabun + "에 해당하는 직원이 없습니다"));
		
		return User.builder()
					.username(jikwon.getJikwonname())
					.password(passwordEncoder.encode(jikwon.getJikwonname())) //패스워드 암호화 시에 정적인 pk는 사용하지 않는다.
					.build();
	} 
	
	
}
