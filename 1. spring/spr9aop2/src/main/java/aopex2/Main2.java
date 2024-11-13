package aopex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopex2.xml");
		LogicInter inter = (LogicInter) context.getBean("logicImpl");
		inter.selectDataProcess1();
		inter.selectDataProcess2();		
	}
}
