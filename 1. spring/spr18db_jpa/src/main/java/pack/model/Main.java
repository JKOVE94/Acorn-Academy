package pack.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pack.business.BusinessInter;

@Configuration
@ComponentScan(basePackages = {"pack.model","pack.business"})
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		BusinessInter inter = context.getBean("businessImpl", BusinessInter.class);
		inter.dataList();
	}
}
