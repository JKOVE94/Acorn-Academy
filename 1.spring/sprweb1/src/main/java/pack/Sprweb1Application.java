package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.abc.Myclass;

@SpringBootApplication
public class Sprweb1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb1Application.class, args);
		
		//WebApplication 이 아닌 일반 Application 구현 방법
		/*
		SpringApplication application = new SpringApplication(Sprweb1Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args); 
		*/
		/*
		SpringApplication.run(Sprweb1Application.class, args)
						.getBean(Sprweb1Application.class).execute();
		*/
	}
	@Autowired
	Myclass myclass;
	
	private void execute() {
		System.out.println("응용 프로그램 실행"); 
		myclass.abc();
	}
}
