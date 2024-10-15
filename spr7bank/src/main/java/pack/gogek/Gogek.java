package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.SinhanBank;

@Service
@Scope("prototype")
@ComponentScan("pack.bank")
public class Gogek {
	private Bank bank;
	
	@Autowired //타입에 의한 매핑
	private SinhanBank sinhanBank;
	
	@Resource(name = "hanaBank") // 이름에 의한 매핑
	private HanaBank hanaBank;
	
	
	public void selectBank(String sel) {
		if(sel.equals("sinhan")) {
			bank = sinhanBank;
		}
		else if(sel.equals("hana")) {
			bank = hanaBank;
		}
	}
	
	public void playInputMoney(int money) {
		bank.inputMoney(money);
	}
	
	public void playOutputMoney(int money) {
		bank.outputMoney(money);
	}
	
	private String msg;
	
	@PostConstruct //생성자 처리후 자동 발생
	public void kbs() {
		msg = "계좌 잔고 : ";
	}
	
	public void showMoney() {
//		System.out.println("계좌 잔고 : "+ bank.getMoney());
		System.out.println(msg+ bank.getMoney());
	}
	
	@PreDestroy //서비스가 종료되기 바로 직전에 실행
	public void end() {
		if(sinhanBank != null) sinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
}
