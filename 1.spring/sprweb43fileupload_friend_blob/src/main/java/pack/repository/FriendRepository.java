package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer>{

	//bunho는 프로그램으로 자동증가 설정
	@Query("SELECT MAX(f.bunho) FROM Friend f")
	Integer findLastBunho();
	
}