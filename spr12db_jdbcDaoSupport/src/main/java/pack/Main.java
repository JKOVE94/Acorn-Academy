package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dbinit.xml");
		BusinessInter inter = context.getBean("businessImpl",BusinessInter.class);
		inter.dataList();		
	}
}
