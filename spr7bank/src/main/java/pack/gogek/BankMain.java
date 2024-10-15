package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");
		
		Gogek tom = (Gogek) context.getBean("gogek");
		tom.selectBank("sinhan");
		tom.playInputMoney(3000);
		tom.playOutputMoney(4000);
		System.out.print("Tom - ");
		tom.showMoney();
		System.out.println();
		
		Gogek john = (Gogek) context.getBean("gogek");
		john.selectBank("sinhan");
		john.playInputMoney(3000);
		john.playOutputMoney(4000);
		System.out.print("John - ");
		john.showMoney();
		System.out.println();
		
		Gogek daniel = (Gogek) context.getBean("gogek");
		daniel.selectBank("hana");
		daniel.playOutputMoney(500);
		System.out.print("Daniel - ");
		daniel.showMoney();
		
//		System.out.println("\nTom - "+tom+"\nJohn - "+john);
	}
}
