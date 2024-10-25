package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SangpumDao {

	
	@Autowired
	private SangpumRepository repository; 
	
	//전체 자료 읽기
	public List<SangpumEntity> getDataAll(){
		List<SangpumEntity> list = repository.findAll();
		System.out.println("list : "+ list.size() + "개");
		return list;
	}
	
	//검색용 - 쿼리메소드
	public List<SangpumEntity> getDataSearch(String svalue){
		List<SangpumEntity> slist = repository.findBysangContaining(svalue);
		System.out.println("list : "+ slist.size() + "개");
		return slist;
	}
	
	//검색용 - JPQL
		public List<SangpumEntity> getDataSearch2(String svalue){
			List<SangpumEntity> slist = repository.MySearch(svalue);
			System.out.println("list : "+ slist.size() + "개");
			return slist;
		}
	
}
