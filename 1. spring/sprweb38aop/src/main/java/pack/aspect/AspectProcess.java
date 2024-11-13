package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectProcess {

	@Autowired
	private Security class1;
	
	@Around("execution(public String processMsg()) or execution(public String businessMsg())")
	public Object abc(ProceedingJoinPoint joinpoint) throws Throwable {
		class1.mySecurity();
		Object object = joinpoint.proceed();
		
		return object;
	}
	
}
