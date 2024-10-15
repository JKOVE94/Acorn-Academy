package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 일반객체


//@Component //Sender sender = new Sender(); => 싱글톤으로
@Component("sender") //이름은 임의로 설정 가능하다. but 해당 클래스를 직관적으로 파악할수 있는 이름이 좋다. ex) kbs 
@Scope("singleton") // prototype 으로 설정하면 복수개의 객체가 생성된다.

//public class Sender{
public class Sender implements SenderInter{
	
	@Override
	public void show() {
		System.out.println("show 메소드 수행");
	}
}
