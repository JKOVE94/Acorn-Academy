package pack.business;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pack.business","pack.model"})
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		BusinessInter inter = context.getBean("businessImpl", BusinessInter.class);
		inter.printJikwonData();
		System.out.println();
		inter.printBuserInwon();
		System.out.println();
//		inter.printBuserTopSal();
	}
	

}
