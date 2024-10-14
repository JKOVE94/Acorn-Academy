package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:imsi/arrange.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/arrange.xml");
		
		//Singleton 확인
		MessageInter messageInter = (MessageInter) context.getBean("mImpl");
		MessageInter messageInter2 = (MessageInter) context.getBean("mImpl");
		messageInter.sayHi();
		messageInter2.sayHi();
		System.out.println(messageInter+" "+messageInter2);
		System.out.println(messageInter==messageInter2); //두개의 객체의 주소가 같다 즉 싱글톤이다.
	}

}
