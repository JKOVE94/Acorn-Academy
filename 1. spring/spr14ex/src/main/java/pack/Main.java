package pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "pack")
@EnableAspectJAutoProxy
public class Main {
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		 BusinessInter inter = context.getBean("businessImpl",BusinessInter.class);
		 inter.printAll();
	}
}
