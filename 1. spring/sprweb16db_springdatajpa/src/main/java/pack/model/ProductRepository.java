package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductVo, Integer>{
	//...
	//JPA에는 규칙에 따르면 메소드를 생성할 수 있고 자동으로 JPQL로 매핑된다.
	//원래는 findProductByCode 규칙이나 Entity명은 생략 가능하다. 
	ProductVo findByCode(Integer code); //메소드 이름으로 쿼리 생성 find+entity명+By+field명 => entity명은 생략 가능
	
	//JPQL : ...
	@Query("SELECT p FROM ProductVo AS p")
	List<ProductVo> findAllData();
	
	//where 조건
	@Query("SELECT p FROM ProductVo AS p WHERE p.code=:code") //이름기반 매핑
	ProductVo findByCodeMy(@Param("code")int code);
	
	@Query("SELECT p FROM ProductVo AS p WHERE p.code=?1") //위치(순서)기반 매핑
	ProductVo findByCodeMy2(int code);
	
	@Query("SELECT p FROM ProductVo AS p WHERE p.code=?1 OR p.sang=?2") //위치(순서)기반 매핑
	List<ProductVo> findByCodeMy3(int code, String sang);
	
	// nativeQuery 문 사용 (SQL) => 최대한 자제
	@Query(value="SELECT code, sang, su, dan FROM product WHERE code <= 3", nativeQuery=true)
	List<ProductVo> findAllDataNative();
}
