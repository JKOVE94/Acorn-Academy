package pack;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Login {
	public boolean tryLogin() {
		boolean isCollect = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PW : ");
		String pw = sc.nextLine();
		sc.close();
		
		if (!id.equals("hi") || !pw.equals("hello")) {
			System.out.println("입력한 정보가 잘못되었습니다");
			isCollect = false;
		}
		
		return isCollect;
	}
}
