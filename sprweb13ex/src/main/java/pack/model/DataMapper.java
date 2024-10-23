package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapper {

	@Select("SELECT j.jikwonno, j.jikwonname, j.jikwonjik, b.busername, j.jikwonpay FROM jikwon AS j INNER JOIN buser AS b ON j.busernum = b.buserno")
	List<JikwonDto> getAllJik();
	
	@Select("SELECT j.jikwonno, j.jikwonname, j.jikwonjik, COALESCE(b.busername,'부서 없음') AS busername, j.jikwonpay FROM jikwon AS j"
			+ " LEFT JOIN buser AS b ON j.busernum = b.buserno WHERE j.jikwonname LIKE CONCAT('%', #{jikwonname}, '%')")
	List<JikwonDto> getJikSearch(String jikwonname);
}
