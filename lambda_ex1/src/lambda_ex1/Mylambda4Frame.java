package lambda_ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Mylambda4Frame {
	
	public static void main(String[] args) {
		//이벤트 처리 : 람다식 사용
		
		JFrame frame = new JFrame("람다 연습용");
		
		JButton button1 = new JButton("클릭1");
		JButton button2 = new JButton("클릭2");
		JButton button3 = new JButton("클릭3");
		
		//전통적인 방법
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("전통적 방법으로 이벤트 처리");
				
			}
		});
		
		//람다 사용
		button2.addActionListener(e-> System.out.println("람다로 이벤트 처리"));
		
		button3.addActionListener(e -> calledMethod());
		
		frame.add("North", button1); //해당 위치(North, Center, South)에 버튼 추가 
		frame.add("Center", button2);
		frame.add("South", button3); 
		frame.setBounds(200,200,300,300); //frame의 너비 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); // 무한 루프에 걸려있어서 프로그램이 종료되지 않는다. 
	}
	
	static void calledMethod() {
		ArrayList<Jikwon> jikwons = new ArrayList<Jikwon>();
		jikwons.add(new Jikwon(3, "홍두깨"));
		jikwons.add(new Jikwon(1, "고길동"));
		jikwons.add(new Jikwon(2, "나길동"));
		
		System.out.println("정렬 전 자료 출력");
		for(Jikwon jikwon : jikwons) {
			System.out.println(jikwon.bunho +" " +jikwon.irum);
		}
		jikwons.forEach(jikwon -> System.out.println(jikwon.bunho +" " +jikwon.irum));
		
		
		System.out.println("Collection.sort 사용--------------");
		Collections.sort(jikwons, new Comparator<Jikwon>(){
			public int compare(Jikwon o1, Jikwon o2) {
				return o1.bunho - o2.bunho;
			};
		});
		
		System.out.println("정렬 후 1 :");
		jikwons.forEach(jikwon -> System.out.println(jikwon.bunho +" " +jikwon.irum));
		
		System.out.println("정렬 후 2(람다) :");
		Collections.sort(jikwons, (o1, o2) -> o1.bunho - o2.bunho);
		jikwons.forEach(jikwon -> System.out.println(jikwon.bunho +" " +jikwon.irum));
	}
	
	static class Jikwon{
		int bunho;
		String irum;
		
		public Jikwon(int bunho, String irum) {
			this.bunho=bunho;
			this.irum=irum;
		}
	}
}