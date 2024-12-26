package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		//AuthenticationManager는 인증 로직의 중심 역할을 하며, 요청을 처리한다.
		//AuthenticationConfiguration은 Spring Security의 AuthenticationManager를 설정 및 관리하는 도우미 역할을 한다.
		return configuration.getAuthenticationManager(); 
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth ->  //"HTTP 요청에 대한 권한 설정을 정의한다
			auth.requestMatchers("/auth/login","/auth/logout","/static/**") //특정 URL 패턴에 대한 접근 제어 규칙을 설정한다 
				.permitAll() //모든 사용자에게 접근을 허용한다
				.anyRequest() //그 외의 모든 요청은
				.authenticated()) //인증된 사용자만 접근할 수 있도록 설정한다
			.formLogin(formLogin ->
				formLogin.loginPage("/auth/login") //사용자 정의 로그인 페이지의 URL을 지정한다
						 .loginProcessingUrl("/auth/login") //로그인 폼 데이터가 전송될 URL을 지정한다. 이 URL은 실제로 컨트롤러에 매핑될 필요는 없다. Spring Security가 내부적으로 처리한다
						 .usernameParameter("sabun") //로그인 폼에서 사용자 ID를 입력받는 input 필드의 name 속성 값을 지정한다. 기본값은 'username'이다
						 .passwordParameter("irum") //로그인 폼에서 비밀번호를 입력받는 input 필드의 name 속성 값을 지정한다. 기본값은 'password'이다
						 .defaultSuccessUrl("/auth/success", true) //로그인 성공 후 리다이렉트할 URL을 지정한다. 두 번째 매개변수 true는 항상 이 URL로 리다이렉트하도록 설정한다. false는 기존에 접속하려던 url로 이동한다.
						 .permitAll())
			.logout(logout ->
				logout.logoutUrl("/auth/logout") //로그아웃 요청을 처리할 URL을 지정한다
					  .logoutSuccessUrl("/auth/login") //로그아웃 성공 후 리다이렉트할 URL을 지정한다
					  .invalidateHttpSession(true) //로그아웃 시 현재 사용자의 HTTP 세션을 무효화한다
					  .clearAuthentication(true) //현재 사용자의 인증 정보를 제거한다
					  .deleteCookies("JSESSIONID") //세션이 저장된 JSESSIONID 쿠키 제거
					  .permitAll());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
