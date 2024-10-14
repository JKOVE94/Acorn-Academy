package pack.business;

import java.util.Scanner;

import pack.model.MoneyInter;

public class MyProcess implements MyProcessInter {
	private MoneyInter inter;
	private int re[];
	
	public MyProcess(MoneyInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void inputMoney() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("금액 입력 :");
			int myMoney = scanner.nextInt();
			re = inter.calcMoney(myMoney);
			
		}catch (Exception e) {
			System.out.println("inputMoney err : "+e);
		}
	}
	
	@Override
	public void showMoney() {
		StringBuilder sb = new StringBuilder();
		String[] units = {"만원","천원","백원","십원","일원"};
		for(int i=0; i<re.length;i++) {
			sb.append(units[i] + " : " + re[i] + "\n");
		}
		System.out.println(sb.toString());		
	}

}
