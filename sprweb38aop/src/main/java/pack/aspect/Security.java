package pack.aspect;

import org.springframework.stereotype.Component;

@Component
public class Security { //관심사항
	
	public void mySecurity() {
		System.out.println("핵심 메소드 수행 전에 보안 작업 설정");
	}
}
