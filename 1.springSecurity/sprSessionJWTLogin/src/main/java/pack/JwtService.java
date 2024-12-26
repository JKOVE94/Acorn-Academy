package pack;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Service
public class JwtService {

	private Key key;
	
	@PostConstruct
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}
	
	public String createToken(String id) {
		return Jwts.builder()
				.setSubject(id)
				.setIssuedAt(new Date()) //생성
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) //만료시간 1시
				.signWith(key) // 암호화
				.compact();
	}
	
	//토큰 내에서 사용자 id를 추출하기 위한 메소드 
	public String getUserIdFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key) //암호와 알고리
				.build()
				.parseClaimsJws(token) //token 설정
				.getBody() //바디 가져오기
				.getSubject(); //id를 보관하고 있는 Subject 가져오기
	}
}
