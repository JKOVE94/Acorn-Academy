package spr10aopex;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice {
	@Around("execution(public void startProcess())")
	public Object abc(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("핵심 메소드 수행 전 id 검증");
		System.out.print("input id : ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		sc.close();

		if (!id.equals("aa")) {
			System.out.println("id 불일치! 작업을 종료합니다.");
			return null; // "aa"가 아닌 조건에서는 null이 리턴됨으로 핵심로직이 실행되지 않는다.
		}
		
		Object object = joinPoint.proceed();
		return object;

	}
}
