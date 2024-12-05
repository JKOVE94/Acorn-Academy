package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyProcess {
	@Value("#{dataInfo.name}") // SpEL : 동적으로 표현식을 해석 #{표현식}
	private String name;
	private String part;
	
	public MyProcess() {
	}
	
	@Autowired // Configuration XML파일을 통해서 해당 생성자가 설정되었다면 XML이 우선으로, 없다면 @Value 어노테이션이 우선순위를 갖는다.
//	public MyProcess(@Value("총무부") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) {
		this.part = part; //생성자를 통해 부서명이 주입 => "총무부" 라는 value가 들어가 있는 String part 매개변수를 필드변수에 주입
	}
	
	@Value("#{dataInfo.job}")
	private String job;
	
	@Value("177")
	private int height;
	
	@Value("1,2,3,4,5") // 배열의 초기값 부여도 가능
	private int arr[];
	
	public void showResult() {
		System.out.println("name : " + name);
		System.out.println("part : " + part);
		System.out.println("job : " + job);
		System.out.println("height : " + (height+3));
		System.out.println("arr : " + arr[0] + " " + arr[3]);
	}
}
