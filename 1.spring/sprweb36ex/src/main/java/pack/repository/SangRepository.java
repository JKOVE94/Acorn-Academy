package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Sang;

public interface SangRepository extends JpaRepository<Sang, Integer>{

	@Query("SELECT MAX(s.code) FROM Sang s")
	int getMax();
	
}
