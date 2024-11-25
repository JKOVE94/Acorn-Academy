package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT MAX(u.userno) FROM User u")
	public long findMaxUserNo();
}
