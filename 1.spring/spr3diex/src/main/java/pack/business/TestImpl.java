package pack.business;

import java.util.Scanner;

import pack.model.SangpumImpl;

public class TestImpl implements TestInter {
	SangpumImpl sangpumImpl;
	String message;
	
	//기본 생성자를 까먹지 맙시다!
	//생성자 주입은 Spring init.xml에서
	public TestImpl(SangpumImpl sangpumImpl) {
		this.sangpumImpl = sangpumImpl;
	}
	
	@Override
	public void inputData() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("상품명 : ");
			String sang = sc.nextLine();
			System.out.print("수량 : ");
			int su = sc.nextInt();
			System.out.print("단가 : ");
			int dan = sc.nextInt();
			message = sangpumImpl.calcMoney(sang, su, dan);
		}catch(Exception e) {
			System.out.println("inputData err :"+e);
		}
	}

	@Override
	public void showResult() {
		System.out.println(message);
	}
}
