package advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//관심사항(로그인, 트랜젝션, 로깅...)을 핵심로직 대상 메소드의 앞 또는 뒤에 적어준다.
		System.out.println("핵심 로직 수행 전 관심사항 코드 삽입");
		
		String methodName = invocation.getMethod().getName();
		
		System.out.println("Joinpoint 대상 메소드명 : "+methodName);
		
		Object object = invocation.proceed(); // 핵심로직 중 Joinpoint 대상 메소드
	
		System.out.println("핵심 로직 수행 후 관심사항 기술");
		
		return object; //object를 return하지 않으면 AOP가 실행되지 않음
	}
}