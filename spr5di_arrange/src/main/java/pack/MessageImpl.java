package pack;

import other.OutFileInter;

public class MessageImpl implements MessageInter{
	//Constructor Injection
	private String name1, name2; 
	private int year;
	private OurInfo ourInfo;
	
	//Property Injection (Setter Injection)
	private String spec;
	private OutFileInter outFileInter;
	
	public MessageImpl() {
	}
	
	public MessageImpl(String name1, String name2, int year, OurInfo ourinfo) {
		this.name1 = name1;
		this.name2 = name2;
		this.year = year;
		this.ourInfo = ourinfo;
	}
	
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	//기본적으로 Interface를 member field에 넣어주면 해당 Interface의 sub Class가 복수개일것임을 인지해야한다.
	public void setOutFileInter(OutFileInter outFileInter) {
		this.outFileInter = outFileInter;
	}
	
	@Override
	public void sayHi() { //출력 담당
		String msg = name1 + " " + name2+ "\n" 
					+ (year+24) + "년! "+ ourInfo.myHobby();
		msg += "\n" + spec;
		
		System.out.println(msg); // console로 출력
		
		//console로 출력된 message File로 출력
		outFileInter.outFile(msg);
	}

}
