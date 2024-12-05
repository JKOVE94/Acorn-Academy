package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Buser;

public interface BuserRepository extends JpaRepository<Buser, Integer>{

	@Query("SELECT DISTINCT b.busername FROM Buser AS b")
	List<String> getBuser();
	
	
}
