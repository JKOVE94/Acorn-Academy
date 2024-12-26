package pack.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

// JWT를 생성하고 검증하는 클래스
@Component
public class JwtUtil {
	private final String SECRET_KEY = "mySuperSecretKey12345678901234567890123456789012";
	private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간
	
	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}
	
	public String generateToken(String sabun) {
		return Jwts.builder()
					.setSubject(sabun)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
					.signWith(getSigningKey())
					.compact();
	}
	
	public Claims extractClaims(String token) {
		return Jwts.parserBuilder()
					.setSigningKey(getSigningKey())
					.build()
					.parseClaimsJws(token)
					.getBody();
	}
	public String extractUsername(String token) {
		return extractClaims(token).getSubject();
	}
	
	//JWT 유효성 검증
	public boolean validateToken(String token) {
		try {
			Claims claims = extractClaims(token);
			return !claims.getExpiration().before(new Date()); //만료되지 않은경우에 true 반환
		} catch (Exception e) {
			//예외 상황 : 토큰 서명이 잘못되었을 경우, JWT구조가 올바르지 않은 경우, 기
			return false;
		}
	}
}
