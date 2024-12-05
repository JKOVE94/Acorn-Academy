package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	
	@Autowired
	JikwonInter inter;
	
	public BusinessImpl() {}
	
	@Override
	public void printJikwonData() {
		List<JikwonDto> list = inter.SelectAll();
		System.out.println("직원자료");
		System.out.println("사번\t이름\t부서명\t입사년");
		for(JikwonDto d : list ) {
			System.out.println(d.getJikwonno()+"\t"+d.getJikwonname()+"\t"+d.getBusername()+"\t"+d.getJikwonibsail().substring(0,4));
		}
	}
	@Override
	public void printBuserInwon() {
		List<JikwonDto> list = inter.FindInwon();
		System.out.println("부서별 인원수");
		for(JikwonDto d : list) {
			System.out.println(d.getBusername()+"\t"+d.getInwon());
		}
		
	}
	@Override
	public void printBuserTopSal() {
		List<JikwonDto> list = inter.FindTopSal();
		System.out.println("부서별 최대 급여자");
		for(JikwonDto d : list) {
			System.out.println(d.getBusername()+" : "+d.getJikwonname()+" ("+d.getJikwonpay()+")");
		}
	}
}
