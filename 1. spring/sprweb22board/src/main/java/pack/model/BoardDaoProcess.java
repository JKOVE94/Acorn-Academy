package pack.model;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDaoProcess {

	@Autowired
	private BoardRepository boardRepository;
	private Logger logger = LoggerFactory.getLogger(getClass());

	// AutoIncrement => 추가시 num이 자동으로 최대값 +1
	public int getMax() {
		int max = boardRepository.getMax();
		return max + 1;
	}

	// 조회수 증가
	@Transactional
	public void updateReadcnt(int num) {
		boardRepository.updateReadCnt(num);
	}
	
	//부모글의 nested값을 return
	public int getSuperNested(int num) {
		int superNested = boardRepository.getNested(num);
		return superNested;
	}
	
	//부모글의 onum값을 return
	public int getSuperGnum(int num) {
		int superGnum = boardRepository.getGnum(num);
		return superGnum;
	}
	
	//기존 글 비밀번호 찾기 (비교용)
	public String getPass(int num) {
		return boardRepository.getPass(num);
	}

	// 전체자료 읽기
	public Page<Board> listAll(int page) {
		// JPARepository가 상속받은 인터페이스 중 PagingAndSortingRepository<T,ID> 로 인해 정렬및 페이징이
		// 가능하다.

		// findAll(Sort.by(정렬방식, 1차키, 2차키,...) 를 사용하면 정렬가능하고 다중으로도 key를 설정 가능하다
		// List<Board> list = boardRepository.findAll(Sort.by(Sort.Direction.DESC,
		// "gnum", "onum"));

		// 다중 정렬
		// Sort Class 안에 Order 클래스가 내부 클래스로 있다. => 해당 내부 클래스를 활용하여 다중정렬 조건을 각각 입력할 수 있다.
//		List<Board> list = boardRepository.findAll(Sort.by(Sort.Order.desc("gnum"),Sort.Order.asc("onum")));

		// 이렇게도 가능하다. 입력한 순서에 따라 1차키(bdate), 2차키(gnum), 3차키(onum)로 설정되었다.
		Sort sort = Sort.by(Sort.Order.desc("gnum"), Sort.Order.asc("nested"), Sort.Order.desc("onum"));

		// Page number, PageSize, 정렬기준(Sort 객체)
		Pageable pageable = PageRequest.of(page, 10, sort);
		Page<Board> list = boardRepository.findAll(pageable);

		// 전체 레코드 수가 12개 가정
		logger.info("page number : " + list.getPageable().getPageNumber() + 1);
		logger.info("page size : " + list.getSize());
		logger.info("total page : " + list.getTotalPages());
		logger.info("total count(record) : " + list.getTotalElements());
		logger.info("has next page : " + list.nextPageable()); // 다음 페이지가 있을 경우 페이지의 정보 return / hasNext() 도 가능 (true
																// /false return)
		logger.info("반환된 레코드 수 :{} ", list.getContent().size()); // 리스트 안의 Board 크기

		return list;
	}

	// 검색
	public Page<Board> search(BoardBean bean) {
		Sort sort = Sort.by(Sort.Order.desc("gnum"), Sort.Order.asc("nested"), Sort.Order.desc("onum"));
		Pageable pageable = PageRequest.of(0, 10, sort);
		Page<Board> slist = null;
		if (bean.getSearchName().equals("title")) {
			slist = boardRepository.searchByTitle(pageable, bean.getSearchValue());
		} else {
			slist = boardRepository.searchByName(pageable, bean.getSearchValue());
		}

		return slist;
	}

	// 입력, 수정
	@Transactional
	public String insertAndUpdate(BoardBean bean) {
		Board board = new Board(bean.getNum(), bean.getName(), bean.getPass(), bean.getMail(), bean.getTitle(),
				bean.getCont(), bean.getBip(), bean.getBdate(), bean.getReadcnt(), bean.getGnum(), bean.getOnum(),
				bean.getNested());

		try {
			boardRepository.save(board);
			return "success";
		} catch (Exception e) {
			return "입력/수정 오류" + e.getMessage();
		}
	}
	
	@Transactional
	public String update(BoardBean bean) {
		try {
			Optional <Board> b = boardRepository.findById(bean.getNum());
			Board board = b.get();
			board.setName(bean.getName());
			board.setMail(bean.getMail());
			board.setTitle(bean.getTitle());
			board.setCont(bean.getCont());
			//save()가 없어도 Entity의 변화가 발생했으므로 자동 수정됨.
			return "success";
		} catch (Exception e) {
			return "수정 오류" + e.getMessage();
		}
	}
	

	// 특정 자료 읽기 : 상세보기, 수정, 삭제용
	public Board detail(int num) {
		Optional<Board> vo = boardRepository.findById(num);
		logger.info("board type:{}",vo);
		
		if(vo.isPresent()) return vo.get(); //Optional -> Board			
		else return new Board();
		
	}
	
	//특정 자료 삭제
	public String delete(int num) {
		try {
			boardRepository.deleteById(num);;
			return "success";
		} catch (Exception e) {
			return "삭제 오류" + e.getMessage();
		}
		
	}
	
	//댓글 
	@Transactional
	public String reply(BoardBean bean) {
		Board board = new Board(bean.getNum(), bean.getName(), bean.getPass(), bean.getMail(), bean.getTitle(),
				bean.getCont(), bean.getBip(), bean.getBdate(), bean.getReadcnt(), bean.getGnum(), bean.getOnum(),
				bean.getNested());
		
		boardRepository.updateOnum(bean.getGnum(), bean.getOnum()); //댓글시에 Onum 갱신 -> 기존 댓글들의 Onum은 +1씩 증가
		
		try {
			boardRepository.save(board);
			return "success";
		} catch (Exception e) {
			return "댓글 오류" + e.getMessage();
		}
	}
	
}
