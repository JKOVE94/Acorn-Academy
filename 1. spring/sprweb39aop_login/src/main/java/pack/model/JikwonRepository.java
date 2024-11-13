package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	@Query(value = "SELECT j FROM Jikwon j WHERE j.jikwonno = :jikwonno ")
	Jikwon jikwonLogin(@Param("jikwonno")String jikwonno);
}
