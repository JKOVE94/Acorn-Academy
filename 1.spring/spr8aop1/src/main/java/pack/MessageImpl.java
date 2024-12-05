package pack;

/*
 * AOP는 비즈니스 로직을 구현한 코드에서 공통기능 코드를 직접 호출하지 않는다.
 * AOP를 적용하면 공통기능과 비즈니스 기능을 따로 개발한 후 컴파일하거나 컴파일 된 클래스를 로딩하는 시점 등에
 * AOP가 적용되어 비즈니스 로직 코드 사이에 공통 기능 코드가 자동으로 삽입된다.
 * 기존의 프로그래밍에서는 각 객체 별로 적용했던 기능을 AOP에서는 각각의 관심사항별로 외부에서 추가하게 된다.
 * 공통의 관심사항을 핵심로직에 적용함으로 해서 발생할 수 있는 의존관계의 복잡성과 중복 코드를 해소해 주는 프로그래밍 기법.
 */

public class MessageImpl implements MessageInter {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHi() {
		System.out.println("안녕 "+ name + "님 핵심 로직 처리 중");
		
		//시간 끌기용 코드 추가
		int t = 0;
		while(t<5) {
			try {
				Thread thread = new Thread();
				thread.sleep(1000);
				System.out.print(".");
				t++;
			}catch (Exception e) {
				System.out.println("sayHi err :"+e);
			}
		}
		System.out.println("\nsayHi 처리 완료");
	}
}
