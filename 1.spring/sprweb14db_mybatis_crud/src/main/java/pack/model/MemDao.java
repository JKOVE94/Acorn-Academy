package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import pack.controller.MemBean;

@Repository
public class MemDao {

	@Autowired
	private MemMapperInter mapperInter;

	// 전체 데이터 찾기
	public List<MemDto> getDataAll() {
		List<MemDto> list = mapperInter.getAll();
		return list;
	}

	// 수정 삭제 대상 자료 읽기
	public MemDto getData(String num) {
		MemDto dto = mapperInter.getPart(num);
		return dto;
	}

	// 추가
	public boolean insertData(MemBean bean) {
		// 번호 자동 증가 또는 번호 중복 확인 작업 이 꼭 필요하다! : but 이번 프로젝트는 생략
		try {
			int re = mapperInter.insertData(bean);
			if (re > 0) return true;
			else return false;
			
		} catch (Exception e) {
			System.out.println("insertData : " + e);
			return false;
		}
	}

	// 수정
	public boolean updateData(MemBean bean) {
		try {
			int re = mapperInter.updateData(bean);
			if (re > 0) return true;
			else return false;
		} catch (Exception e) {
			System.out.println("insertData : " + e);
			return false;
		}
	}

	// 삭제
	public boolean deleteData(String num) {
		try {
			int re = mapperInter.deleteData(num);
			if (re > 0) return true;
			else return false;
		} catch (Exception e) {
			System.out.println("insertData : " + e);
			return false;
		}
	}

}
