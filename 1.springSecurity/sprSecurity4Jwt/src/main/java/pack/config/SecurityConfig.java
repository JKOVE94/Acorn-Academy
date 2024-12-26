package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import pack.JwtAuthenticationFilter;
import pack.util.JwtUtil;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	private final JwtUtil jwtUtil;
	
	public SecurityConfig(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	/* JWT 사용시 주요 사항
	* 1) 세션관리는 비활성화 (세션 대신 STATELESS 보안 사용)
	* 2) JWT 필터 추가 : 요청마다 JWT토큰을 확인하고 인증정보를 설정하기 위한 커스텀 필터를 만듬
	* 3) Form 기반 인증 제거 : JWT 인증에서는 로그인 페이지보다는 REST API 를 로그인 요청으로 처리 하므로 formLogin() 설정을 제거 
	*/
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
		http.csrf(csrf -> csrf.disable()) //csrf비활성화. JWT는 csrf공격을 받을 확률이 희박하기에 csrf를 비활성화. (JWT 헤더를 인증하기 때문)
			.authorizeHttpRequests(auth ->  //"HTTP 요청에 대한 권한 설정을 정의한다
				auth.requestMatchers("/auth/login","/auth/logout","/static/**") //특정 URL 패턴에 대한 접근 제어 규칙을 설정
					.permitAll() //모든 사용자에게 접근을 허용한다
					.requestMatchers("/auth/gugu", "/auth/guguresult", "auth/success") //특정 URL 패턴에 대한 접근 제어 규칙을 설정
					.authenticated()) //인증된 사용자만 접근할 수 있도록 설정한다
					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //JWT를 사용하니까 SESSION을 사용하지 않겠다는 정책설정
					.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		//AuthenticationManager는 인증 로직의 중심 역할을 하며, 요청을 처리한다.
		//AuthenticationConfiguration은 Spring Security의 AuthenticationManager를 설정 및 관리하는 도우미 역할을 한다.
		return configuration.getAuthenticationManager(); 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
