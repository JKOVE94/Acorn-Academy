package anno3_etc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno3Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("anno3.xml");
		MyProcess myProcess = (MyProcess) context.getBean("myProcess");
		myProcess.showResult();
	}
}
