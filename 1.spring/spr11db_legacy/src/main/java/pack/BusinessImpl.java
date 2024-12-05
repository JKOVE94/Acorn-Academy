package pack;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter {
	
	@Autowired
	//@Qualifier("sangpumImpl") <- SangpumInter를 상속받는 Class가 여러개일 경우 지정하는 방법
	private SangpumInter sangpumInter;
	
	@Override
	public void dataList() {
		ArrayList<SangpumDto> list = sangpumInter.selectList();
		for(SangpumDto s :list) {
			System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan()); 
		}
	}
}
