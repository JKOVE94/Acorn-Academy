package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {

	@Autowired
	private JikwonRepository repository;
	
	//Like 사용 X, Position 방식 매핑 
	public List<JikwonEntity> searchJikwon(String jikwonjik, String jikwongen){
		List<JikwonEntity> list = repository.findJikwon(jikwonjik, jikwongen);
		return list;
	}
	
	//Like 사용 O, Name 방식 매핑
	public List<JikwonEntity> searchJikwon2(String jikwonjik, String jikwongen){
		List<JikwonEntity> list = repository.findJikwonLike(jikwonjik, jikwongen);
		return list;
	}
	
	//Like 사용 O, Name 방식 매핑
		public List<JikwonEntity> getAlljik(String jikwongen){
			List<JikwonEntity> list = repository.findAllJikwon(jikwongen);
			return list;
		}
	
}
