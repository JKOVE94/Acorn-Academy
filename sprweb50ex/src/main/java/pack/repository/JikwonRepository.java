package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Jikwon;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	@Query("SELECT j FROM Jikwon AS j JOIN j.gogekList AS g WHERE g.gogekno=?1 AND g.gogekname LIKE CONCAT('%',?2,'%')")
	Jikwon getDamJik(String gogekno, String gogekname);
}
