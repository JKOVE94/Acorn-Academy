package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //Spring Security 기능을 설정 (보안설정, 인증, 폼 로그인...)
public class SecurityConfig {
	@Bean //약결합, 강결합 : extends, implements
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth ->  //http 요청에 대한 보안 설정 부분
			auth.requestMatchers("/login", "/kbs", "/mbc/**")
			.permitAll()
			.anyRequest()
			.authenticated() //인증된 경우에만 접근 허용
		)
		.formLogin(flog -> 
			flog.loginPage("/login") //사용자 정의 로그인 페이지 지정
			.defaultSuccessUrl("/", true) //인증에 성공한 후 redirect할 URL 지정
			.permitAll()
		)
		.logout(logout -> 
			logout.logoutUrl("/logout")
			.deleteCookies("JSESSIONID")
			.permitAll()
		);
		return http.build(); //SecurityFilterChain 로 security 설정을 할 수 있다.
	}
	
	// security가 제공하는 기본 로그인 정보 대신 사용자 입력 로그인 정보를 사용하기
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
								.username("myuser")
								.password(passwordEncoder().encode("111"))
//								.roles("USER")
								.build();
		
		// 인증 테스트용 => 영구적 저장소가 아닌 RAM에 저장. 재시작하면 정보가 사라짐
		return new InMemoryUserDetailsManager(user);
		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //알고리즘 객체의 하나
	}
}
//SecurityFilterChain : 클라이언트의 요청을 가로채서 설정된 인증, 인가 부분을 체크 
//HttpSecurity : 특정 http 요청에 대해 어떠한 보안 정책을 적용할지 구성하는데 사용
