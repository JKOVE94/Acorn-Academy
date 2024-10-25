package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {

	@Autowired
	private MemCrudRepository repository; //Hikari CP 자동 지원
	
	//전체자료 읽기
	public List<Mem> getDataAll(){
		List<Mem> list = repository.findAll();
		return list;
	}
	
	//부분자료 읽기
	public Mem getMemberByNum(int num) {
		Mem mem = repository.findBynum(num);
		return mem;
	}
	
	//입력
	public String insertData(MemBean bean) {
		String msg="입력 자료 오류";
		// 가장 큰 번호를 구해 +1 하고 추가시 사용
//		int max = repository.findByMaxNum()+1;
//		Mem nMem = new Mem(max,mem.getName(),mem.getAddr());
		
		//입력한 번호 중복확인
		try {
			Mem mem = repository.findById(bean.getNum()).get();
			msg="이미 등록된 번호입니다 ";
			return msg;
			
		} catch (Exception e) {
			//findById의 결과가 에러인 경우 (등록 가능한 번호)
			try {
				Mem mem = new Mem(bean.getNum(),bean.getName(),bean.getAddr());
				repository.save(mem);
				msg="success";
				
			} catch (Exception e2) {
				System.out.println("insert err"+e2);
			}
		}
		return msg;
	}
	
	//수정
	public String updateData(MemBean bean) {
		try {
			Mem mem = new Mem(bean.getNum(),bean.getName(),bean.getAddr());
			repository.save(mem);
			return "success";
		} catch (Exception e) {
			return "수정 작업 오류 : "+e;
		}
	}
	
	//삭제
	public String deleteData(Integer num) {
		try {
			repository.deleteById(num);
			return "success";
		} catch (Exception e) {
			return "삭제 작업 오류 : "+e;
		}
	}
	
	
}
