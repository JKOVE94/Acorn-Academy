package pack;

public class MessageImpl implements MessageInter{
	private String name1, name2; //생성자 주입용
	
	public MessageImpl() {
	}
	
	public MessageImpl(String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
	}
	
	@Override
	public void sayHi() { //출력 담당
		String msg = name1 + " " + name2;
		
		System.out.println(msg);
	}

}
