package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper
public interface DataMapperInter {

	@Select("SELECT code, sang, su, dan FROM sangdata")
	List<SangpumDto> selectAll();
	
//	@Select("SELECT code, sang, su, dan FROM sangdata WHERE sang LIKE '%' || #{searchValue} || '%'") Orcale에서 사용할 때 
	@Select("SELECT code, sang, su, dan FROM sangdata WHERE sang LIKE CONCAT('%',#{searchValue}, '%')") //MariaDB에서 사용할 떄
	List<SangpumDto> selectSearch(FormBean bean); //상품명별 검색

}
