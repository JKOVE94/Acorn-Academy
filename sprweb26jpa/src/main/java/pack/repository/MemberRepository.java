package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
