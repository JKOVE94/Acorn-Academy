package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataProcess {

	//처음에 시도했던 방법. 복수의 Repository를 활용해서 값을 찾는 방법
	//처음에는 JPQL을 잘못 설정해서 Type Match Error가 발생해서 2개의 Repository를 활용하는 방법을 채택했다.
	/*
	@Autowired
	private JikwonRepository jikwonRepository;
	
	public List<JikwonDto> getAllJikwonWithGogek(){
		return jikwonRepository.selectJikwonWithGogek()
				.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	*/
	
	@Autowired
	private GogekRepository gogekRepository;
	
	public List<JikwonDto> getAllJikwonWithGogek(){
		return gogekRepository.selectJikwonWithGogek()
				.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
		
	public List<GogekDto> getAllGogekWithJikwonno(String jikwonno){
		return gogekRepository.selectDamGogek(jikwonno)
				.stream()
				.map(GogekDto :: fromEntity)
				.collect(Collectors.toList());
	}
}
