package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDao;
import pack.model.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	//초기 접속시 메인페이지 무의미한것같아서 주석 처리
//	@GetMapping("/")
//	public String main() {
//		return "index";
//	}
//	
	//리스트페이지
	@GetMapping("/")
	public String list(Model model) {
		ArrayList<BoardVo> list = (ArrayList<BoardVo>)boardDao.getAllList();
		BoardBean bean = new BoardBean();
		//검색에서 Select의 초기값을 설정하기 위해 비어있는 bean을 전송한다. (th:if bean.searchName 으로 조회하기 때문)
		model.addAttribute("bean", bean);
		model.addAttribute("list", list);
		return "list";
	}
	
	//검색기능
	@PostMapping("search")
	public String search(Model model, BoardBean bean) {
		ArrayList<BoardVo> list = (ArrayList<BoardVo>) boardDao.search(bean);
		//유저가 검색한 bean의 정보를 가지고 다시 돌아간다. -> 해당 정보로 유저가 입력한 값이 무엇인지 표시해준다 (UI)
		model.addAttribute("bean", bean);
		model.addAttribute("list", list);
		return "list";
	}
	
	//게시글의 세부 정보
	@GetMapping("detail")
	public String detail(Model model, @RequestParam("num")int num) {
		boardDao.viewIncrement(num);
		BoardVo vo = boardDao.getOne(num);
		model.addAttribute("board", vo);
		return "detail";
	}
	
	//게시글 작성 페이지 이동
	@GetMapping("insert")
	public String insform() {
		return "insform";
	}
	
	//게시글 작성, 수정, 삭제는 MODEL에서 try catch로 오류를 체크한뒤 boolean 타입으로 반환한다. 해당 boolean 값에 따라 list페이지(true) error페이지(false) 로 이동한다.
	
	//게시글 작성 실행
	@PostMapping("insert")
	public String insProcess(Model model, BoardBean bean) {
		boolean b = boardDao.insert(bean);
		if(b) return "redirect:list";
		else return "error";
	}
	
	//게시글 수정
	@PostMapping("update")
	public String upProcess(Model model, BoardBean bean) {
		boolean b = boardDao.update(bean);
		if(b) return "redirect:list";
		else return "error";
	}
	
	//게시글 삭제
	@GetMapping("delete")
	public String delProcess(Model model, @RequestParam("num")int num) {
		boolean b = boardDao.delete(num);
		if(b) return "redirect:list";
		else return "error";
	}
}
