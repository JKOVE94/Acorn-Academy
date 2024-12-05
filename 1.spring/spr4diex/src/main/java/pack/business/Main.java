package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.model.CalcInter;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		OurProcess ourProcess = (OurProcess) context.getBean("ourProcess");
		ourProcess.displayData();
	}

}
