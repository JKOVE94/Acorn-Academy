package aopex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//핵심 로직

@Service //객체생성, Business Logic 
public class LogicImpl implements LogicInter{
	
	@Autowired
	private ArticleInter articleInter;
	
	public LogicImpl() {} //Spring에서 기본 생성자는 생성을 권장한다.
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행");
		articleInter.selectAll();
	}
	
	@Override
	public void selectDataProcess2() {
		System.out.println("selectDataProcess2 수행");
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("selectDataProcess2 err :"+e);
		}
		System.out.println("selectDataProcess2 수행 최종 소요 시간 3초");
	}

}
