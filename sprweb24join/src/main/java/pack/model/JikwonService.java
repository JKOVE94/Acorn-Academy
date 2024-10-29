package pack.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonService {

	@Autowired
	private JikwonRepository jikwonRepository;
	
	public List<JikwonDto> getJikwonData(){
		//전체자료 읽기 1
		List<Jikwon> list = jikwonRepository.findAllWithBuser();
		List<JikwonDto> jikwonDtoList = new ArrayList<JikwonDto>();
		for(Jikwon jik : list) {
			jikwonDtoList.add(JikwonDto.fromEntity(jik));
		}
		return jikwonDtoList;
	}
}
