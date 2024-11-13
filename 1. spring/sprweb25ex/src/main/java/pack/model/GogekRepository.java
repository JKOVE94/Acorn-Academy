package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GogekRepository extends JpaRepository<Gogek, Integer>{

	//INNER JOIN을 사용하면 해당 조건에 만족하지 않는 record는 탈락하게 된다.
	//즉 고객 jikwonno 와 gogekdamsano가 key로 묶여있는 관계에 해당되지 않으면 출력되지 않는다.
	// = 고객을 관리하고 있는 직원 리스트
	@Query("SELECT j FROM Gogek AS g JOIN g.jikwon AS j")
	public List<Jikwon> selectJikwonWithGogek();
	
	@Query("SELECT g FROM Gogek As g JOIN jikwon AS j WHERE j.jikwonno = ?1")
	public List<Gogek> selectDamGogek(String jikwonno);
}
