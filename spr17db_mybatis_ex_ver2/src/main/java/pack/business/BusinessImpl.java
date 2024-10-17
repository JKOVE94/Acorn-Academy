package pack.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import pack.model.InwonDto;
import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {

	@Autowired
	JikwonInter inter;

	MultiValueMap<Integer, Integer> buserSal = new LinkedMultiValueMap();
	ArrayList<Integer> keyList = new ArrayList();
	
	
	public BusinessImpl() {}
	
	@Override
	public void JikwonSal() {
		try {
			List<JikwonDto> list = inter.SelectJikwon();
			for (JikwonDto d : list) {
				buserSal.add(d.getBusernum(), d.getJikwonpay());
			}
			Iterator<Integer> it = buserSal.keySet().iterator();
			while(it.hasNext()) {
				keyList.add(it.next());
			}
			System.out.println(keyList.size());
		} catch (Exception e) {
			System.out.println("BusinessImpl err :"+e);
		}
	}
	
	@Override
	public void JikwonSalRun() {
		JikwonSal();
		for(int i : keyList) {
			for(int o : buserSal.get(i)) {
				
			}
		}
	}

	@Override
	public void printJikwonData() {
		Map<Integer, String> map = inter.getBuserInfo();
		
		List<JikwonDto> list = inter.SelectJikwon();
		System.out.println("직원자료");
		System.out.println("사번\t이름\t부서명\t입사년");
		for (JikwonDto d : list) {
			// 직원 사번
			System.out.print(d.getJikwonno() + "\t");
			// 직원 명
			System.out.print(d.getJikwonname() + "\t");
			// 부서명 부서번호가 없을시 무소속 표시, 아닐시 부서명 표시
			if (d.getBusernum()==0) {
				System.out.println("무소속\t");
			} else {
				System.out.print(map.get(d.getBusernum()) + "\t");
			}
			System.out.print(d.getJikwonibsail().substring(0, 4));
			System.out.println();
		}

	}

	@Override
	public void printBuserInwon() {
		List<InwonDto> list = inter.FindInwon();
				
		System.out.println("부서별 인원수");
		for (InwonDto d : list) {
			System.out.println(d.getBusername() + " " + d.getInwon());
		}
	}

	@Override
	public void printBuserTopSal() {
		Map<Integer, String> map = inter.getBuserInfo();
		List<JikwonDto> list = inter.SelectJikwon();


		System.out.println("부서별 최대 급여자");

		for (JikwonDto d : list) {
		}

	}
}
