package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MyProcessInter inter = (MyProcessInter) context.getBean("myProcess");
		inter.inputMoney();
		inter.showMoney();
	}

}
