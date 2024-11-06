package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Gogek;
import pack.entity.Jikwon;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	@Query("SELECT j FROM Jikwon AS j JOIN j.gogekList AS g WHERE g.gogekno=?1 AND g.gogekname LIKE CONCAT('%',?2,'%')")
	Jikwon getDamJik(String gogekno, String gogekname);
	
	@Query("SELECT j FROM Jikwon AS j JOIN j.buser AS b WHERE b.busername=?1")
	List<Jikwon> getJikWithBuser(String busername);
	
	@Query("SELECT g FROM Jikwon AS j JOIN j.gogekList AS g WHERE j.jikwonno = ?1")
	List<Gogek> getGogekWithJikwon(String jikwonno);
}
