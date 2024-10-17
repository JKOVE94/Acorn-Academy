package pack.business;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pack.business", "pack.model"})
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		BusinessInter businessInter = context.getBean("businessImpl", BusinessInter.class);
		businessInter.dataPrint();	
	}
}
