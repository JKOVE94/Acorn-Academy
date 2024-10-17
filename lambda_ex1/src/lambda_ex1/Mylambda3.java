package lambda_ex1;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Mylambda3 {

	public Mylambda3() {
		// 람다 표현식 사용 연습
		test1(); //List consumer
		test2(); //Thread runnable
		test3(); // File accept
	}

	private void test1() {
		// List의 각 요소를 출력하기
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list.getClass().getName());
		System.out.println(list instanceof List);
		
		for(String i:list) {
			System.out.println(i);
		}
		System.out.println();
		
		//람다 표현식 사용
		//acecept 메소드를 통해서 i를 불러온다.
		list.forEach(i -> System.out.println(i));
		System.out.println();
		
		//------------실제 forEach를 실행했을때 발생하는 일---------------------
		Consumer<List<String>> consumer = new Consumer<List<String>>() {
			@Override
			public void accept(List<String> t) {
				for(String s : t) {
					System.out.println(s);
				}
				
			}
		};
		consumer.accept(list);
		//------------실제 forEach를 실행했을때 발생하는 일---------------------
		
	}
	
	//--------------------------- Thread 관련 ---------------------------
	// 내부 클래스
	class ThreadTest {
		public void sendData(String friend) {
			System.out.println(friend + "에게 문자 전송");
		}
		
		public ThreadTest(){
			
		}
		
		void m1() { //전통적인 방법
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					sendData("미스터 톰");
					
				}
			}).start();
		}
		
		void m2() { // 람다식 표현 Runnable 인터페이스
			Runnable runnable = () -> sendData("브라이언");
			runnable.run();
		}
		void m3() { //람다식 표현 Thread 생성자 사용
			Thread thread = new Thread(() -> sendData("린다"));
			thread.start();
		}
		void m4() { // 람다식 표현 Thread 생성자 사용, 생성자에 바로 접근
			new Thread(() -> sendData("베티")).start();
		}
	}
	
	private void test2() {
		ThreadTest threadTest = new ThreadTest();
		threadTest.m1(); //전통적인 방법
		threadTest.m2(); // 람다식 표현 Runnable 인터페이스
		threadTest.m3(); // 람다식 표현 Thread 생성자 사용
		threadTest.m4(); // 람다식 표현 Thread 생성자 사용, 생성자에 바로 접근
	}
	//--------------------------- Thread 관련 ---------------------------
	
	private void test3() { // FileFilter 인터페이스 accept 메소드 (람다식)
		//특정 폴더에 있는 파일 필터링
		File direc = new File("C:\\work");
		File[] files = direc.listFiles((File file) -> file.isFile() && file.getName().endsWith(".txt"));
		System.out.println(files.length);
		if(files !=null) {
			for(File f : files) {
				System.out.println(f.getName());
			}
		}
	}

	public static void main(String[] args) {
		new Mylambda3();
	}
}
