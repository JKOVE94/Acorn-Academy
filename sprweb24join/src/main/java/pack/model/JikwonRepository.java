package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	//Inner Join
	@Query("SELECT j FROM Jikwon AS j JOIN j.buser AS b")
	List<Jikwon> findAllWithBuser(); //Inner Join. 일반적으로 외부조인(Outer Join)보다는 내부조인(Inner Join)이 성능이 우수한것으로 알려져 있다.

	@Query("SELECT j FROM Jikwon AS j JOIN j.buser AS b WHERE j.jikwonpay >= 5000")
	List<Jikwon> findAllWithHighPay(); //조건부 Join.
	
	@Query("SELECT j FROM Jikwon AS j JOIN j.buser AS b WHERE b.busername = :buserName")
	List<Jikwon> findAllByBuserName(@Param("buserName")String buserName); //
	
	//Left Outer Join : 왼쪽테이블 기준으로 오른쪽 테이블 삽입 (왼쪽 테이블은 모든 자료 반환하고, 오른쪽은 대응하는 데이터가 없을 시 null)
	@Query("SELECT j FROM Jikwon AS j LEFT JOIN j.buser AS b")
	List<Jikwon> findAllWithBuserLeftJoin();

	//Right Outer Join : 오른쪽테이블 기준으로 왼쪽 테이블 삽입 (오른쪽 테이블은 모든 자료 반환하고, 왼쪽은 대응하는 데이터가 없을 시 null)
	@Query("SELECT j FROM Jikwon AS j RIGHT JOIN j.buser AS b")
	List<Jikwon> findAllWithBuserRightJoin();
	
	//Fetch Join : 연관된 엔티티의 쿼리를 한번에 메모리로 로딩 (Join과 유사하지만 Eager Fetch)
	//@Query("SELECT j FROM Jikwon AS j FETCH j.buser AS b")
	//List<Jikwon> findAllWithBuserFetch();
	
	//Native Query
	@Query(value = "SELECT * FROM jikwon AS j JOIN buser AS b ON j.busernum = b.buserno", nativeQuery = true)
	List<Jikwon> findAllWithBuserNative();
	
	//Sub Query
}

