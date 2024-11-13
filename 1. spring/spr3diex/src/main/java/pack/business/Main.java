package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		TestInter testInter = (TestInter) context.getBean("testImpl");
		testInter.inputData();
		testInter.showResult();
	}	
}