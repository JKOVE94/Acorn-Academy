package anno2_resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno2Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("anno2.xml");
		AbcProcess abcProcess = context.getBean("ap", AbcProcess.class);
		abcProcess.showData();
	}
}
