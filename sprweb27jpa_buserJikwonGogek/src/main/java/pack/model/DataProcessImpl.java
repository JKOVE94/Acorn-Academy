package pack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataProcessImpl implements DataProcess{

	@Autowired
	private BuserRepository buserRepository;
	@Autowired
	private GogekRepository gogekRepository;
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Override
	public List<JikwonDto> jikwonBuserList(){ //직원 + 부서 읽기
		List<Jikwon> list = jikwonRepository.findAll();
		return list.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	@Override
	public List<JikwonDto> jikwonGogekList(){ //직원 + 고객 읽기
		List<Jikwon> list2 = jikwonRepository.findAll();
		return list2.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	//고객의 담당 직원 정보 출력 (DTO상태로 리스트 전송 후 View에서 작업)
	@Override
	public List<GogekDto> GogekDamdangList(){ //직원 + 고객 읽기
		List<Gogek> list3 = gogekRepository.findAll();
		return list3.stream()
				.map(GogekDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	//고객의 담당 직원 정보 출력 (Model에서 작업후 String 리스트로 전송)
	@Override
	public List<String> GogekDamdangListStr(){ //직원 + 고객 읽기
		List<String> damdangList = new ArrayList<String>();
		List<Gogek> list4 = gogekRepository.findAll();
		
		list4.forEach(e ->
		damdangList.add("고객 " + e.getGogekname()+"님의 담당 사원은 "+e.getJikwon().getJikwonname()+" "
						+e.getJikwon().getJikwonjik()+"입니다. 전화번호는 "
						+e.getJikwon().getBuser().getBusertel()+"입니다"));

		return damdangList;
	}
	
	//고객의 담당 직원 정보 출력 (Model에서 작업후 String 리스트로 전송) Ver2
	@Override
	public List<String> GogekDamdangListStr2(){ //직원 + 고객 읽기
		List<String> damdangList = new ArrayList<String>();
		List<Gogek> list4 = gogekRepository.findAll();
		
		for(Gogek gogek : list4) {
			if(gogek.getJikwon() != null) {
				String ss = String.format("고객 %s의 담당 직원은 %s %s. 전화 : %s",gogek.getGogekname(),
						gogek.getJikwon().getJikwonname(),gogek.getJikwon().getJikwonjik(),
						gogek.getJikwon().getBuser().getBusertel());
				damdangList.add(ss);
			}
		}

		return damdangList;
	}
}
