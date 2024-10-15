package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//비지니스 로직

//@Component @Component와 @Service는 기능이 유사하지만 직관성을 위해서 해당 명칭을 가진 어노테이션이 Spring Framework내에 존재한다.
@Service
//@Service("senderProcess") - 두개의 어노테이션은 같은 의미이다.

public class SenderProcess {
	//@Autowired : type에 의한 매핑!!! => 이름에 의한 매핑은 Java가 제공한다.
	
	//@Autowired //Field Injection
	//private Sender sender;
	
	// Autowired는 Type에 의한 매핑이기 때문에 Field에 SenderInter를 멤버로 설정하면, 
	// SenderInter를 구현한 Send Class는(SenderInter Type) SenderInter 멤버에 자동으로 연결이 될 수 있다.
	
	
	//@Autowired 는 Type에 의한 매핑이기 때문에 만약 같은 Interface나 같은 Super Class를 갖는 여러개의 클래스가 있을경우에는
	//@Qualifier를 통해서 해당 객체의 이름을 작성해줘야한다.
	
	@Autowired 
	@Qualifier("sender2") 
	private SenderInter inter;
	
//	@Autowired //Constructor Injection 
//	public SenderProcess(Sender sender) {
//	}
	
//	@Autowired //Setter Injection 
//	public void setSender(Sender sender) {
//		this.sender = sender;
//	}
	
	public void displayData() {
		//sender.show();
		inter.show();
	}
}
