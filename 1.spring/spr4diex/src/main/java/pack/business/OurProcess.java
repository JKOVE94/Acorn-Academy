package pack.business;

import java.util.Scanner;

import pack.model.Gugudan;

public class OurProcess {
	private String writer;
	private int dan;
	private Gugudan gugu;
	
	public OurProcess() {
	}
	
	public void setWriter(String writer) {
		this.writer = inputName();
	}

	public void setDan(int dan) {
		this.dan = inputDan();
	}

	public void setGugu(Gugudan gugu) {
		this.gugu = gugu;
	}	
	
	public String inputName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 이름은? :");
		String name=sc.nextLine();
		return name;
	}
	public int inputDan() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계산하고자 하는 단은? :");
		int danNum=sc.nextInt();
		return danNum;
	}
	
	public void displayData() {
		int[] gugudan = gugu.numberCalc(dan);
		System.out.println("환영합니다. "+writer+"님");
		for(int i=0; i<gugudan.length; i++) {
			System.out.println(dan+"X"+(i+1)+"="+gugudan[i]);
		}
	}
}
