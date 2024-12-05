package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Exercises;

public interface ExerciseRepository extends JpaRepository<Exercises, Long>{

	@Query("SELECT MAX(e.exid) FROM Exercise e")
	public long getMaxNum();
}
