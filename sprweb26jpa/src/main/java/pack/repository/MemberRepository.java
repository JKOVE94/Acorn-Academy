package pack.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	public List<Member> findAllByOrderByNumDesc();
	
//	@Query("SELECT MAX(m.num) FROM Member AS m")
//	public Long getMax();
}
