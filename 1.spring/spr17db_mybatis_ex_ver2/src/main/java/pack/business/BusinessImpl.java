package pack.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {

	@Autowired
	JikwonInter inter;

	//기본 생성자
	public BusinessImpl() {}

	//부서 번호가 들어있는 List 반환
	@Override
	public List<Integer> getBuserNumList(){
		MultiValueMap<Integer, Integer> buserSal = getJikwonMultiValueMap();
		List<Integer> keyList = new ArrayList<Integer>(buserSal.keySet());
		return keyList;
	}
	
	//부서별 최대 급여자 
	@Override
	public HashMap<Integer, Integer> getJikwonTopSalMap() {
		HashMap<Integer, Integer> buserTopSal = new HashMap<Integer, Integer>();
		MultiValueMap<Integer, Integer> buserSal = getJikwonMultiValueMap();
		List<Integer> keyList = getBuserNumList();
		for (int busernum : keyList) {
			int maxSal = 0;
			Iterator<Integer> itor = buserSal.get(busernum).iterator();
			while (itor.hasNext()) {
				int nextSal = itor.next();
				if (maxSal < nextSal) {
					maxSal = nextSal;
				}
			}
			buserTopSal.put(busernum, maxSal);
		}
		return buserTopSal;
	}
	
	
	//부서별 직원의 급여가 담긴 맵
	@Override
	public MultiValueMap<Integer, Integer> getJikwonMultiValueMap() {
		MultiValueMap<Integer, Integer> buserSal = new LinkedMultiValueMap();
		try {
			List<JikwonDto> list = inter.SelectJikwon();
			for (JikwonDto d : list) {
				buserSal.add(d.getBusernum(), d.getJikwonpay());
			}
		} catch (Exception e) {
			System.out.println("BusinessImpl err :" + e);
		}
		return buserSal;
	}

	// 직원의 전체 정보 출력
	@Override
	public void printJikwonData() {
		//부서 번호 Key, 부서명 Value로 담고있는 map
		Map<Integer, String> map = inter.getBuserInfo();
		//직원 전체의 정보를 JikwonDto로 담고 있는 List
		List<JikwonDto> list = inter.SelectJikwon();
		System.out.println("직원자료");
		System.out.println("사번\t이름\t부서명\t입사년");
		for (JikwonDto d : list) {
			// 직원 사번
			System.out.print(d.getJikwonno() + "\t");
			// 직원 명
			System.out.print(d.getJikwonname() + "\t");
			// 부서명 부서번호가 없을시 무소속 표시, 아닐시 부서명 표시
			if (map.get(d.getBusernum()) == null) {
				System.out.print("무소속\t");
			} else {
				System.out.print(map.get(d.getBusernum()) + "\t");
			}
			System.out.print(d.getJikwonibsail().substring(0, 4));
			System.out.println();
		}
	}
	
	
	@Override
	public void printBuserInwon() {
		MultiValueMap<Integer, Integer> buserSal = getJikwonMultiValueMap();
		List<Integer> keyList = getBuserNumList();
		
		Map<Integer, String> map = inter.getBuserInfo();
		System.out.println("부서별 인원수");
		for (int i : keyList) {
			if (map.get(i) == null) {
				System.out.print("무소속 : ");
			} else {
				System.out.print(map.get(i) + " : ");
			}
			System.out.println(buserSal.get(i).size());
		}
	}
	
	//각 부서별 최대 급여를 받는 직원 정보 출력
	@Override
	public void printBuserTopsal() {
		MultiValueMap<Integer, Integer> buserSal = getJikwonMultiValueMap();
		List<Integer> keyList = getBuserNumList();
		HashMap<Integer, Integer> buserTopSal = getJikwonTopSalMap();
		Map<Integer, String> map = inter.getBuserInfo();
		List<JikwonDto> list = inter.SelectJikwon();
		System.out.println("부서별 최대 급여자");
		for (int i : keyList) {
			int max = 0;
			if (map.get(i) == null) {
				System.out.print("무소속 : ");
			} else {
				System.out.print(map.get(i) + " : ");
			}
			for (JikwonDto d : list) {
				if (buserTopSal.get(i) == d.getJikwonpay() && d.getBusernum() == i ) {
					System.out.print(d.getJikwonname()+" ("+d.getJikwonpay()+")  ");
				}
			}
			System.out.println();
		}
	}
}
