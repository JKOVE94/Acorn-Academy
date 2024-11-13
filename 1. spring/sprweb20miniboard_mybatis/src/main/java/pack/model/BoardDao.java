package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {

	@Autowired
	private DataMapperInter mapperInter;

	// 전체자료 읽기
	public List<Board> list() {
		List<Board> list = null;
		try {
			list = mapperInter.selectList();
		} catch (Exception e) {
			System.out.println("list err : " + e);
		}
		return list;
	}

	//상세보기
	public Board detail(String num) {
		mapperInter.updateReadcnt(num); //조회수 증가
		Board dto = mapperInter.selectOne(num);
		return dto;
	}

	// 추가
	public boolean insert(BoardBean bean) {
		boolean b = false;
		int re = mapperInter.insert(bean);
		if (re > 0) b = true;
		return b;
	}

	//검색
	public List<Board> search(BoardBean bean) {
		List<Board> list = null;
		try {
			list = mapperInter.selectSearch(bean);
		} catch (Exception e) {
			System.out.println("list err : " + e);
		}
		return list;
	}
	
	// 수정 후 목록보기
	@Transactional	
	public boolean update(BoardBean bean) {
			boolean b = false;
			if (mapperInter.update(bean) > 0) b = true;
			return b;
		}
		
		@Transactional
		public boolean Delete(String num) {
			boolean b = false;
			if (mapperInter.delete(num) > 0) b = true;
			return b;
		}
	

}
