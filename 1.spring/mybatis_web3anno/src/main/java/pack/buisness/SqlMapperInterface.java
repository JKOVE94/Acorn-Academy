package pack.buisness;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SqlMapperInterface {
	@Select ("SELECT * FROM membertab")
	public List<DataDto> selectDataAll(); //전체 자료 읽기
	
	@Select ("SELECT id, name, passwd, regdate FROM membertab WHERE id=#{id}")
	public DataDto selectDataByPart(String id); //부분 자료 읽기
	
	@Insert ("INSERT INTO membertab VALUES(#{id},#{name},#{passwd},now())")
	public int insertData(FormBean bean); //자료 입력
	
	@Update("UPDATE membertab SET name=#{name} WHERE id=#{id}")
	public int updateData(FormBean bean); //자료 수정
	
	@Delete("DELETE FROM membertab WHERE id=#{id}")
	public int deleteData(String id); //자료 삭제
	
}
