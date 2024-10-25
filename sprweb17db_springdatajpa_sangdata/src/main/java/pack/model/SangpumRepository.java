package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SangpumRepository extends JpaRepository<SangpumEntity, Integer>{

	//쿼리 메소드 작성 규칙(Naming Rule)
	
	List<SangpumEntity> findBysangContaining(String svalue); // Containing = like '%검색%' 
	List<SangpumEntity> findBysangStartingWith(String svalue); // Containing = like '검색%' 
	List<SangpumEntity> findBysangEndingWith(String svalue); // Containing = like '%검색' 
	//...
	
	//JPQL
	@Query("SELECT s FROM SangpumEntity AS s WHERE s.sang LIKE %:svalue%")
	List<SangpumEntity> MySearch(@Param("svalue")String svalue); // Containing = like '%검색' 
}
