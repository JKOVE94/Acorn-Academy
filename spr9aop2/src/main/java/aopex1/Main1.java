package aopex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopex1.xml");
		LogicInter inter = (LogicInter) context.getBean("logicImpl");
		inter.selectDataProcess1();
		inter.selectDataProcess2();
		
	}
}
