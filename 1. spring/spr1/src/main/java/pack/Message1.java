package pack;

public class Message1 implements MessageInter {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕 "+name);
	}
}
