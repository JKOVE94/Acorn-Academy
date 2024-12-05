package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.JikwonDao;
import pack.model.JikwonEntity;

@Controller
public class JikwonController {

	@Autowired
	private JikwonDao jikwonDao;
	
	//메인페이지 이동, 페이지는 1개만 운용, static이 아닌 templates에 페이지 위치
	@GetMapping("/")
	public String main(Model model) {
		//사이즈를 0을 가지고 이동 - size가 0이면 결과 테이블 안보이게, 총 인원수 안보이게 설정
		JikwonBean bean = new JikwonBean();
		model.addAttribute("size",0);
		model.addAttribute("bean",bean);
		return "list";
	}

	@GetMapping("search")
	public String search(JikwonBean bean, Model model) {
		ArrayList<JikwonEntity> list=null;
		if(bean.getJikwonjik().equals("전체")) {
			list = (ArrayList<JikwonEntity>) jikwonDao.getAlljik(bean.getJikwongen());
		}
		else {
		//Like 사용 X, Position 방식 매핑 
		//ArrayList<JikwonEntity> list = (ArrayList<JikwonEntity>) jikwonDao.searchJikwon(bean.getJikwonjik(), bean.getJikwongen());
		
		//Like 사용 O, Name 방식 매핑
		list = (ArrayList<JikwonEntity>) jikwonDao.searchJikwon2(bean.getJikwonjik(), bean.getJikwongen());
		}
		
		//Controller에서 size 계산 => 한페이지에서 모든것을 해결하고 싶었는데 View에서 size를 계산하니까 null인 경우의 에러가 자꾸 발생했다.
		int size=list.size();
		model.addAttribute("size",size);
		model.addAttribute("bean",bean);
		model.addAttribute("list", list);
		return "list";
	}
	
	
}
