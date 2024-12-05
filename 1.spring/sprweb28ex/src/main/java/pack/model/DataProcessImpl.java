package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataProcessImpl implements DataProcess{
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Override
	public List<JikwonDto> jikwonBuserList() {
		List<Jikwon> jlist = jikwonRepository.findAll();
		return jlist.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	@Override
	public JikwonDto jikwonGogekList(int jikwonno) {
		Jikwon jlist = jikwonRepository.findById(jikwonno).get();
		return JikwonDto.builder()
				.jikwonname(jlist.getJikwonname())
				.jikwonjik(jlist.getJikwonjik())
				//Entity에는 외부의 데이터를 추가로 넣을 수 없기에 DTO에 고객의 성별계산, 고객의 나이 계산 메소드가 있음으로 Entity를 Dto로 변경해서 저장
				.gogekDtoList(jlist.getGogekList()
						.stream().map(GogekDto :: fromEntity).
						collect(Collectors.toList()))
				.build();
	}

}
