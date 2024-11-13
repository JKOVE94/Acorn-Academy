package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Jikwon;


public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	@Query("SELECT distinct j.jikwonjik FROM Jikwon AS j")
	List<String> getJik();
	
	@Query("SELECT j FROM Jikwon AS j WHERE j.jikwonjik = ?1 AND j.jikwonrating LIKE ?2")
	List<Jikwon> getJikwon1(String jikwonjik, String jikwonrating);

	@Query("SELECT j FROM Jikwon AS j WHERE j.jikwonjik = ?1 ")
	List<Jikwon> getJikwon2(String jikwonjik);
	
	@Query("SELECT j FROM Jikwon AS j WHERE j.buser.busername = ?1 AND j.jikwonrating LIKE ?2")
	List<Jikwon> getJikwonWithB1(String busername, String jikwonrating);

	@Query("SELECT j FROM Jikwon AS j WHERE j.buser.busername = ?1 ")
	List<Jikwon> getJikwonWithB2(String busername);
	
	
}
