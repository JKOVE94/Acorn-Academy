package anno2_resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("ap")
public class AbcProcess {
	
	@Resource(name="abc1") //객체변수명에 의한 매핑 -> 주로 Spring을 사용하기에 @Resource가 사용되는 경우는 적다
	private Abc1 abc1;
	
	private Abc2 abc2;

	@Resource(name="abc2")
	public void setAbc2(Abc2 abc2) {
		this.abc2 = abc2;
	}
	
	public void showData() {
		abc1.setIrum("tom");
		abc2.setNai(22);
		System.out.println("이름은 : "+abc1.getIrum()+ ", 나이는 :"+ abc2.getNai());
	}
}
