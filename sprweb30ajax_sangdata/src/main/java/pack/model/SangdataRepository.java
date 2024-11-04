package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Sangdata;

public interface SangdataRepository extends JpaRepository<Sangdata, Integer>{

	@Query("SELECT MAX(s.code) FROM Sangdata s")
	public int getMax();
}
