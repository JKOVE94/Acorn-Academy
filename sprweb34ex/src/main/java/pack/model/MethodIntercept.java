package pack.model;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodIntercept implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("text");
		
		Object object = invocation.proceed();
		
		return object;
	}

}
