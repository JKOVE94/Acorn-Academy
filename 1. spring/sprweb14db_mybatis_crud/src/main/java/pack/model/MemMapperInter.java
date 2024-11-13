package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.MemBean;

@Mapper
public interface MemMapperInter {
	
	@Select("SELECT num, name, addr FROM mem")
	List<MemDto> getAll();
	
	@Select("SELECT num, name, addr FROM mem WHERE num=#{num}")
	MemDto getPart(String num);
	
	@Insert("INSERT INTO mem(num, name, addr) VALUES(#{num}, #{name}, #{addr})")
	int insertData(MemBean bean);
	
	@Update("UPDATE mem SET name=#{name}, addr=#{addr} WHERE num=#{num}")
	int updateData(MemBean bean);
	
	@Delete("DELETE FROM mem WHERE num=#{num}")
	int deleteData(String num);
}
