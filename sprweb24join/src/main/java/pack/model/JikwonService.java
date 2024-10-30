package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonService {

	@Autowired
	private JikwonRepository jikwonRepository;
	
	//전체자료 읽기 1
	/*
	public List<JikwonDto> getJikwonData(){
		List<Jikwon> list = jikwonRepository.findAllWithBuser();
		List<JikwonDto> jikwonDtoList = new ArrayList<JikwonDto>();
		for(Jikwon jik : list) {
			jikwonDtoList.add(JikwonDto.fromEntity(jik));
		}
		return jikwonDtoList;
	}
	*/
	
	//전체 자료 읽기 2 - Stream + lambda
	/*
	public List<JikwonDto> getJikwonData(){
		return jikwonRepository.findAllWithBuser()
				.stream()
				.map(jikwon -> JikwonDto.fromEntity(jikwon))
				.collect(Collectors.toList());
	}
	*/
	
	//전체 자료 읽기 3: stream
	public List<JikwonDto> getJikwonData(){
		return jikwonRepository.findAllWithBuser()
				.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
		
	//조건부 JOIN 호출 - stream + lambda
	public List<JikwonDto> getJikwonHighPay(){		
		return jikwonRepository.findAllWithHighPay()
				.stream()
				.map(Jikwon -> JikwonDto.fromEntity(Jikwon))
				.collect(Collectors.toList());
	}
	
	//조건부 JOIN 호출 - stream
	public List<JikwonDto> getAllBuserName(String buserName){
		return jikwonRepository.findAllByBuserName(buserName)
				.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	public List<JikwonDto> getTopPaidJikwon(){
		return jikwonRepository.findTopPayWithSubQuery()
				.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
}
