package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemCrudRepository extends JpaRepository<Mem, Integer> {

	// num 자동 증가 처리를 위한 코드
	@Query(value = "SELECT MAX(m.num) FROM Mem AS m")
	int findByMaxNum();
	
	@Query(value ="SELECT m FROM Mem AS m WHERE m.num =?1")
	Mem findBynum(int num);
}
