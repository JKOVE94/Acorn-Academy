package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter {

	@Autowired
	JikwonInter jikwonInter;

	public BusinessImpl() {
	}

	@Override
	public void printAll() {
		System.out.println("직원번호\t직원명\t부서명\t직급");
		jikwonInter.getAlljikwon().forEach(d -> System.out.println(
				d.getJkiwonno() + "\t" + d.getJikwonname() + "\t" + d.getBusername() + "\t" + d.getJikwonjik()));
		System.out.println("건수: "+jikwonInter.getAlljikwon().size());
	}

}
