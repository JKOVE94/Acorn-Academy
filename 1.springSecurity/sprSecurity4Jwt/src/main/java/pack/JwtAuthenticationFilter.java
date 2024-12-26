package pack;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.util.JwtUtil;

//JWT 인증을 처리하는 필터, 요청이 들어올 때 마다 실행
// 요청에 헤더 또는 쿠키에서 JWT 추출

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	//http요청 당 1번 실행되는 필터 => 동일한 요청내에서 중복 호출 방지를 보장 (불필요한 작업을 방지)
	
	private final JwtUtil jwtUtil;
	private final UserDetailsService userDetailsService;
	
	public JwtAuthenticationFilter(JwtUtil jwtUti, UserDetailsService userDetailsService){
		this.jwtUtil = jwtUti;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//콜백함수, 필터의 핵심로직을 작성하는 부분
		String token = null;
		String authHeader = request.getHeader("Authorization");
		System.out.println("authHeader : "+authHeader);
		
		//토큰을 얻는 방법 2가지 1. HTTP Header, 2. Cookie
		//다양한 클라이언트 환경 및 요청에 대해 유연한 대처가 필요함
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7); // authHeader: Bearer <JWT_TOKEN> => 접두어 제거하고 실제 값 취함
		}else {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie c : cookies) {
					if(c.getName().equals("JWT")) {
						token = c.getValue();
					}
				}
			}
		}
		
		//토큰 검증 및 인증
		if(token != null && jwtUtil.validateToken(token)) {
			String sabun = jwtUtil.extractUsername(token);
			UserDetails userDetails = userDetailsService.loadUserByUsername(sabun);
			
			//(사용자 인증정보 객체, 비밀번호, 사용자 권한목록) => 이미 인증이 끝났기에 password 부분에 null
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	
			//요청 처리 동안, 인증된 사용자 정보가 SecurityContext에 저장 => 저장된 SecurityContext는 SecurityContextHolder에 보관
			SecurityContextHolder.getContext().setAuthentication(authentication); 
		}
		
		//FilterChain은 여러개의 필터가 순차적으로 실행되는 구조. 각 필터는 HTTP요청을 처리 후 다음 필터로 요청을 전달함
		//Session 사용시 사용 불가 (JWT사용, Stateless 정책) => 토큰 기반 인증을 간단히 처리
		filterChain.doFilter(request, response);
	} 
}
