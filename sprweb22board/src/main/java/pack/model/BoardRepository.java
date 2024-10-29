package pack.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	//전체자료 읽기 - Naming Rule
	Page<Board> findByOrderByNumDesc(Pageable pageable);
	
	//JPQL 검색
	@Query("SELECT b FROM Board AS b WHERE b.name LIKE CONCAT('%',?1,'%')") //name 별
	Page<Board> searchByName(Pageable pageable, String searchValue);
	
	@Query("SELECT b FROM Board AS b WHERE b.title LIKE CONCAT('%',:searchValue,'%')") //title 별
	Page<Board> searchByTitle(Pageable pageable, @Param("searchValue")String searchValue);
	
	//추가시 가장 큰 num 얻기
	@Query("SELECT max(b.num) FROM Board AS b")
	int getMax();
	
	// 상세보기 시 조회수 증가
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Board b SET b.readcnt = b.readcnt + 1 WHERE b.num = ?1")
	void updateReadCnt(int num); 
	
	//비밀번호 얻기
	@Query("SELECT b.pass FROM Board AS b WHERE b.num=?1")
	String getPass(int num);
	
	// 댓글 처리에서 같은 그룹내에서 onum 변경
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Board b SET b.onum = b.onum + 1 WHERE b.gnum=?1 AND b.onum>=?2 ")
	void updateOnum(int gnum, int onum);
	
	@Query("SELECT b.nested FROM Board AS b WHERE b.num = ?1")
	int getNested(int num);
	
	@Query("SELECT b.gnum FROM Board AS b WHERE b.num = ?1")
	int getGnum(int num);
	
}
