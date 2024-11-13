package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Sub {
	@Autowired
	Login login;
	
	@Around("execution(public void printAll())")
	public Object subfn(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//관심 - 로그인 기능
		if(login.tryLogin()==false) {
			return null;
		}
		
		Object object = joinPoint.proceed();
		return object;
	}
}
