package pack.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Board;
import pack.model.BoardDaoProcess;

@Controller
public class ListController {

	@Autowired
	private BoardDaoProcess daoProcess;

	@GetMapping("list")
	// @RequestParam 의 Attribute => required : 필수인가? (true/false), defaultValue :
	// 기본값은 어떻게 할것인가?, value : 어떤 파라미터를 가져올 것인가?
	public String listProcess(Model model,
			@RequestParam(required = false, defaultValue = "1", value = "page") int page) {
		Page<Board> list = daoProcess.listAll(page-1);

		int nowPage = list.getPageable().getPageNumber() + 1;

		// 페이지리스트가 보일 숫자 설정
		// Math.max(nowPage-4,1) : 페이지가 최소 1을 취하기 위해서 이러한 입력을 했고, 만약 nowPage가 6이상이 된다면
		// 시작페이지는 2가 된다. 2~최대값
		int startPage = Math.max(nowPage - 4, 1);
		// Math.min(nowPage+5 , list.getTotalPages())
		int endPage = Math.min(nowPage + 4, list.getTotalPages());
		// 즉 위의 세팅은 총 9개의 페이지를 표시 할 수 있는 세팅이다. (좌 4, 기준, 우 4)

		// 만약 현재 페이지가 4라면 1,2,3,4,5,6,7,8 => startPage 설정으로 인해 -> max(4-4==0,1) -> 즉 1부터
		// 시작한다.
		// 만약 현재 페이지가 20이라면 표시되는 페이지는 16,17,18,19,20,21,22,23,24 까지 이다.
		// 만약 최대 페이지가 23페이지까지라면 표시되는 페이지는 16,17,18,19,20,21,22,23 까지 이다. => endPage 설정으로
		// 인해 -> min(20+4==24,23(최대페이지)) -> 즉 23까지만 표시된다.
		
		BoardBean bean = new BoardBean();

		model.addAttribute("bean", bean);
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		return "list";
	}

	@GetMapping("search")
	public String searchProcess(Model model, BoardBean bean, @RequestParam(required = false, defaultValue = "1", value = "page") int page) {
		Page<Board> slist = daoProcess.search(bean);

		int nowPage = slist.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage - 4, 1);
		int endPage = Math.min(nowPage + 4, slist.getTotalPages());
		if(endPage==0) endPage=1;
		
		model.addAttribute("bean", bean);
		model.addAttribute("list", slist);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);

		return "list";
	}

	
}
