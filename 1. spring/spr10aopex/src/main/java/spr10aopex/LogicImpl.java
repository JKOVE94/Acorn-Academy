package spr10aopex;

import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter {
	
	public LogicImpl() {}
	
	@Override
	public void startProcess() {
		System.out.println("핵심 로직 : 만약 로그인 부가 기능이 추가된다면 로그인 성공시 처리");
	}
}
