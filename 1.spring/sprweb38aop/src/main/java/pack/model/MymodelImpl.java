package pack.model;

import org.springframework.stereotype.Component;

@Component(value = "MymodelImpl")
public class MymodelImpl implements MymodelInter {
	
	@Override
	public String processMsg() {
		System.out.println("processMsg 핵심 메소드 수행");
		return "Spring AOP 멋져!";
	}
	@Override
	public String businessMsg() {
		System.out.println("businessMsg 핵심 메소드 수행");
		return "Spring AOP 매우 멋져!";
	}

}
