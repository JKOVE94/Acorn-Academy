package pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "pack") // 여러 패키지에 Component가 흩어져 있을때에는 배열로 처리하면 된다. (backpackages = {"pack","pack2"...}
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		BusinessInter inter = context.getBean("businessImpl",BusinessInter.class);
		inter.dataList();		
	}
}
