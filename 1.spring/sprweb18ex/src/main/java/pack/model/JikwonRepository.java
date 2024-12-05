package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<JikwonEntity, Integer>{
	
	@Query("SELECT j FROM JikwonEntity AS j WHERE j.jikwongen = ?1")
	List<JikwonEntity> findAllJikwon(String jikwongen);
	
	//Like 사용 X, Position 방식 매핑 
	@Query("SELECT j FROM JikwonEntity AS j WHERE j.jikwonjik = ?1 AND j.jikwongen = ?2")
	List<JikwonEntity> findJikwon(String jikwonjik, String jikwongen);
	
	//Like 사용 O, Name 방식 매핑
	@Query("SELECT j FROM JikwonEntity AS j WHERE j.jikwonjik LIKE %:jikwonjik% AND j.jikwongen LIKE %:jikwongen%")
	List<JikwonEntity> findJikwonLike(@Param("jikwonjik")String jikwonjik, @Param("jikwongen")String jikwongen);
	
	
}
