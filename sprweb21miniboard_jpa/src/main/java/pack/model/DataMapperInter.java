package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DataMapperInter extends JpaRepository<BoardVo, Integer>{
	
	@Query("SELECT MAX(num) FROM BoardVo")
	int getMaxnum();
	
	/*Modifying 어노테이션은 SELECT를 제외한 나머지 연산에 사용하는 어노테이션이다.
	 * 붙여주지 않을시 QueryExecutionRequestException 에러가 발생한다.
	 * 에러 예 : Expecting a SELECT Query [org.hibernate.query.sqm.tree.select.SqmSelectStatement], but found org.hibernate.query.sqm.tree.update.SqmUpdateStatement [UPDATE BoardVo b SET b.readcnt = b.readcnt + 1 WHERE b.num =?1 ]
	 * Modifying 조회 쿼리로 간주하고 트랜잭션을 관리하지 않는다.
	 * 
	 * 벌크 연산(대량의 데이터를 한번에 수정, 삭제하는 방법) 을 할 수 있다.
	 * 벌크 연산은 영속성 컨텍스트를 무시하고 DB에 직접 쿼리한다는 점에 주의해야한다.
	 * 그래서 영속성 컨텍스트에 있는 자료와 DB에 있는 자료가 다를 수 있다. 그러므로 영속성 컨텍스트에 있는 쿼리를 flush하거나 clear해야 한다.
	 * 
	 * Modifying에는 2가지 옵션이 있다. (1차 캐시를 비워주는 설정 부여)
	 * - flushAutomatically : 쿼리 실행 전 쓰기 지연 저장소의 쿼리를 flush 하는 옵션
	 * - clearAutomatically : 쿼리 실행 후 영속성 컨텍스트를 비우는 옵션
	*/
	@Modifying(flushAutomatically = true) 
	@Query("UPDATE BoardVo b SET readcnt = readcnt + 1 WHERE num = ?1 ")
	void viewIncrement(int num);
	
	//두개의 쿼리를 하나로 합쳐보려 했지만 JPQL은 필드명을 동적인 할당이 불가능하다고 한다. 그래서 2개의 메소드로 분리했다.
	@Query("SELECT b FROM BoardVo AS b WHERE author LIKE CONCAT('%', ?1,'%')")
	List<BoardVo> searchByAuthor(String searchValue);
	
	//두개의 쿼리를 하나로 합쳐보려 했지만 JPQL은 필드명을 동적인 할당이 불가능하다고 한다. 그래서 2개의 메소드로 분리했다.
	@Query("SELECT b FROM BoardVo AS b WHERE title LIKE CONCAT('%', ?1,'%')")
	List<BoardVo> searchByTitle(String searchValue);
	
}
