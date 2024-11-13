package pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"pack","controller", "business", "model"}) // 클래스의 위치가 다를 경우 이렇게 ComponentScan을 사용하면 된다.
public class Sprweb2getpostApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb2getpostApplication.class, args);
	}
}
