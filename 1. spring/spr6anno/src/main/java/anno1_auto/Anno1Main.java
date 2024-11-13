package anno1_auto;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //명시적(가시적)으로 설정 Class임을 의미
@ComponentScan(basePackages = "anno1_auto")
public class Anno1Main {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("anno1.xml");
		
		//하단의 기능은 Spring 6.0 이상의 version에서만 사용 가능하다.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Anno1Main.class);
		SenderProcess process = context.getBean("senderProcess", SenderProcess.class);
		process.displayData();
	}
}
