package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao implements DataDaoInter{

	@Autowired
	private JikwonRepository repository;
	
	//직원자료 읽기
	@Override
	public List<JikwonDto> getAllJik(){
		List<Jikwon> list = repository.findAll();
		return list.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	//-----로그인 관련--------------------------
	public JikwonDto jikwonLogin(String jikwonno) {
		Jikwon jikwon = repository.jikwonLogin(jikwonno);
		return JikwonDto.fromEntity(jikwon);
	}
	
}
