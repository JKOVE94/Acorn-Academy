package pack.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pack.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{
	List<Emp> findAllByOrderByEmpnoAsc(); // findAll()와 같다.
	
	//위와 결과는 동일하다.
	@Query("SELECT e FROM Emp AS e ORDER BY e.empno ASC")
	List<Emp> getListAll();
	
	//sal 필드 조건 부여
	@Query("SELECT e FROM Emp AS e WHERE e.sal > :sal ORDER BY e.sal ASC")
	List<Emp> getList(@Param("sal")double sal);
	
	//sal 필드 조건 부여2
	@Query("SELECT e FROM Emp AS e WHERE e.sal > :sal AND e.sal < :sal2 ORDER BY e.sal ASC")
	List<Emp> getListBetween(@Param("sal")double sal, @Param("sal2")double sal2 );
	
	//sal 필드 조건 부여2
	@Query("SELECT e FROM Emp AS e WHERE e.sal > ?1 AND e.sal < ?2 ORDER BY e.sal ASC")
	List<Emp> getListBetween2(double sal, double sal2);
	
	
	
}
