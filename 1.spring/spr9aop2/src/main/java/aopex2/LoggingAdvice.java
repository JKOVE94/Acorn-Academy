package aopex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// 관심사항 (부가기능) - aspect

@Aspect //@Aspect는 객체생성까지 되지는 않는다.
@Component
public class LoggingAdvice {
	@Around("execution(* *..*LogicInter*.*(..)) or execution(public void selectAll())")
	public Object mbc(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//-----핵심 메소드 수행 전 처리 내용------
		String mName = joinPoint.getSignature().toString(); //설정된 pointcut 메소드
		
		// Spring Framework에 내장된 Stopwatch 기능
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(); //스탑워치 시작
		
		System.out.println(mName + "시작 전 작업");
		//-----핵심 메소드 수행 전 처리 내용------
		
		Object object = joinPoint.proceed(); //핵심로직에 설정된 joinpoint => pointcut 메소드 (Intercept Target)
		
		//-----핵심 메소드 수행 후 처리 내용------
		System.out.println(mName + "처리 후 마무리");
		stopWatch.stop(); //스탑워치 종료
		
		System.out.println("처리 소요 시간 : "+stopWatch.getTotalTimeMillis());
		//-----핵심 메소드 수행 후 처리 내용------
		
		return object;
	}
}
