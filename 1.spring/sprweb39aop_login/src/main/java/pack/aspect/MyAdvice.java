package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Aspect
@Component
public class MyAdvice {

	@Autowired
	private LoginClass loginClass;
	
	@Around("execution(* jikProcess*(..))")
	public Object abc(ProceedingJoinPoint joinpoint) throws Throwable{
		
		HttpServletRequest req = null;
		HttpServletResponse resp = null;
				
		for(Object obj : joinpoint.getArgs()) {
			if(obj instanceof HttpServletRequest) {
				req = (HttpServletRequest)obj;
			}
			if(obj instanceof HttpServletResponse) {
				resp = (HttpServletResponse)obj;
			}
		}
		if(loginClass.loginCheck(req, resp)) {
			return null;
		}
		
		Object object = joinpoint.proceed();
		return object;
	}
}
