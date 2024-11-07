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
public class AspectProcess {
	
	@Autowired
	private Login login;
	
	@Around("execution(* damdang*(..))")
	public Object processAspect(ProceedingJoinPoint joinpoint) throws Throwable{
		
		HttpServletRequest req = null;
		HttpServletResponse resp = null;
		
		for(Object o : joinpoint.getArgs()) {
			if(o instanceof HttpServletRequest) {
				req=(HttpServletRequest)o;
			}
			if(o instanceof HttpServletResponse) {
				resp=(HttpServletResponse)o;
			}
		}
		
		if(login.getLogin(req, resp)) {
			return null;
		}
		Object object = joinpoint.proceed();
		return object;
	}
	
}
