package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter{
	
	@Autowired
	private SangpumInter sangpumInter;
	
	public BusinessImpl() {}
	
	@Override
	public void dataList() {
		for(SangpumDto s : sangpumInter.selectList()) {
			System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
		}
		sangpumInter.selectList().forEach(s -> System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan()));
				
	}

}
