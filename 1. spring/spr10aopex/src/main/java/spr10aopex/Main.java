package spr10aopex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopex1.xml");
		LogicInter inter = (LogicInter) context.getBean("logicImpl");
		inter.startProcess();
	}
}
