package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	//Entity에서 @OneToMany와 @ManyToOne로 상호 관계를 만들어주면 서로 참고할 수 있다.
	// 그러나 Repository의 활용은 주가 되는 Entity를 기준으로 하는것이 좋다.
	
//	@Query("SELECT j FROM Jikwon AS j WHERE j.gogekList IS NOT EMPTY")
//	public List<Jikwon> selectJikwonWithGogek();
	
}
