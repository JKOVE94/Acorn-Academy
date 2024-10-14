package pack;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMain {
	public static void main(String[] args) {
		//전통적인 방법으로 객체 생성 후 실행
		Message1 message1 = new Message1();
		Message2 message2 = new Message2();
		
		message1.sayHello("홍두깨");
		message2.sayHello("신기루");
		System.out.println();
		
		MessageInter inter;
		inter = message1;
		inter.sayHello("김밥");
		
		inter = message2;
		inter.sayHello("공기밥");
		System.out.println("-------------------");
		
		//스프링이 생성한 객체를 읽어 실행
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MessageInter inter2 = (MessageInter) context.getBean("mes1"); // context.getBean으로 넘어오는것은 Object 객체
		MessageInter inter3 = (MessageInter) context.getBean("mes2"); // context.getBean으로 넘어오는것은 Object 객체
		
		inter2.sayHello("손오공");
		inter3.sayHello("손오공");
		
	}
}
