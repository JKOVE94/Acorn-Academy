package pack.bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // 기본은 싱글톤
@Scope("prototype")
public class HanaBank implements Bank {
	private int money = 1000;
	
	@Override
	public void inputMoney(int money) {
		int imsi = money;
		this.money = this.money + imsi;
	}
	
	@Override
	public void outputMoney(int money) {
		if(money == 0) return;
		this.money -= money;
	}
	
	@Override
	public int getMoney() {
		return money;
	}

}
