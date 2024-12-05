package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;

@Mapper
public interface DataMapperInter {

	//추상 메소드의 이름은 mapper.xml의 id명과 일치
	List<Board> selectList();
	List<Board> selectSearch(BoardBean bean);
	Board selectOne(String num);
	int insert(BoardBean bean);
	int update(BoardBean bean);
	int updateReadcnt(String num);
	int delete(String num);
	
}
