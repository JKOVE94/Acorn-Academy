package pack.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	
	@Autowired
	private DataMapperInter mapperInter;
	
	//전체 리스트 return
	public List<BoardVo> getAllList(){
		List<BoardVo> list = mapperInter.findAll();
		return list;
	}
	
	//조회수 증가
	@Transactional
	public void viewIncrement(int num) {		
		mapperInter.viewIncrement(num);
	}
	
	// 번호에 맞는 글 1개 가져오기
	public BoardVo getOne(int num) {
		return mapperInter.findById(num).get();
	}
	
	//현재 시간 
	public String getDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regdate = format.format(date);
		return regdate;
	}
	
	//글 번호 증가 (Like as auto increment)
	public int numIncrement() {
		int max = mapperInter.getMaxnum()+1;
		return max;
	}
	
	//글 추가
	public boolean insert(BoardBean bean) {
		boolean b = true;
		try {
			//Entity에 맞게 설정 (글 번호:Auto Increment, bean 작성자, bean 제목, bean 내용, 현재시간 메소드, 조회수 기본값 0) 
			BoardVo vo = new BoardVo(numIncrement(),bean.getAuthor(),bean.getTitle(),bean.getContent(),getDate(),0);
			mapperInter.save(vo);
			
		} catch (Exception e) {
			b=false;
		}
		return b;
	}
	
	//글 수정
	@Transactional
	public boolean update(BoardBean bean) {
		boolean b = true;
		try {
			//글 수정의 경우에는 원본의 정보를(글 번호, 작성일, 조회수) 를 그대로 가져와야 한다. 그렇기 때문에 input type=hidden으로 bean에 담아서 가져온다.
			BoardVo uvo = new BoardVo(bean.getNum(),bean.getAuthor(),bean.getTitle(),bean.getContent(),bean.getBwrite(),bean.getReadcnt());
			mapperInter.save(uvo);			
		}
		catch(Exception e){
			System.out.println("update err :"+e);
			b=false;
		}
		return b;
	}
	
	//글 삭제
	@Transactional
	public boolean delete(int num) {
		boolean b = true;
		try {
			mapperInter.deleteById(num);;
			
		} catch (Exception e) {
			System.out.println("delete err: "+e);
			b=false;
		}
		return b;
	}
	
	//검색 => JPQL은 동적 feild 검색이 안된다고 한다. 그래서 SearchName이 title인 경우, author인 경우 2가지 조건문으로 분리했다.
	public List<BoardVo> search(BoardBean bean){
		System.out.println("Name :"+bean.getSearchName()+" Value :"+bean.getSearchValue());
		List<BoardVo> list = null;
		if(bean.getSearchName().equalsIgnoreCase("title")) {
			list = mapperInter.searchByTitle(bean.getSearchValue());
		}
		else if(bean.getSearchName().equalsIgnoreCase("author")) {
			list = mapperInter.searchByAuthor(bean.getSearchValue());
		}
		return list;
	}
	
	
}
