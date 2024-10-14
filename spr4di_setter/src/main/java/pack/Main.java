package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {		
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MyProcess myProcess = (MyProcess) context.getBean("myProcess");
		myProcess.displayData();
	}
}
