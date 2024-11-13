package lambda_ex1;

interface MyInter {
	void aaa();
}

interface MyInterArg {
	void bbb(int a, int b);
}

interface MyInterArg2 {
	void bbb(int a);
}

interface MyInterArgReturn {
	int ccc(int a, int b);
}

public class Mylambda2 {
	public static void main(String[] args) {
		// 인자가 없는 추상 메소드 처리
		MyInter inter1 = new MyInter() {
			@Override
			public void aaa() {
				System.out.println("익명 클래스의 메소드 오버라이딩");
			}
		};
		inter1.aaa();

		// 1. 인자가 없는 추상 메소드 처리 : 람다식
//		MyInter inter2 = () -> { System.out.println("람다식으로 표현"); };
		MyInter inter2 = () -> System.out.println("람다식으로 표현"); // 수행할 내용이 1가지만 있을경우에는 중괄호 생략 가능
		inter2.aaa();

		MyInter inter3 = () -> {
			int imsi = 10;
			System.out.println(imsi + "람다식으로 표현");
			System.out.println("수행문이 복수이면 블럭 생략 불가");
		};
		inter3.aaa();

		System.out.println("----------------");
		// 2. 인자가 있는 추상 메소드 처리 : 전통적
		MyInterArg interArg = new MyInterArg() {
			@Override
			public void bbb(int a, int b) {
				System.out.println("두 수의 합은 " + (a + b));
			}
		};
		interArg.bbb(3, 4);

		// 2. 인자가 있는 추상 메소드 처리 : 람다식
		MyInterArg interArg2 = (a, b) -> System.out.println("[람다 사용] 두 수의 합은 " + (a + b));
		interArg2.bbb(3, 4);

//		MyInterArg2 myarg = (a) -> System.out.println("[람다 사용] 두 수의 합은 "+ (a+5));
		MyInterArg2 myarg = a -> System.out.println("[람다 사용] 두 수의 합은 " + (a + 5)); // 매개변수가 1개일 때 소괄호 생략 가능
		myarg.bbb(3);

		System.out.println("----------------");
		// 3. 반환값이 있는 추상 메소드 처리 : 전통적
		MyInterArgReturn ArgReturn = new MyInterArgReturn() {
			@Override
			public int ccc(int a, int b) {
				System.out.println("ccc 처리");
				return a + b;
			}
		};
		int result = ArgReturn.ccc(3, 4);
		System.out.println("두 수의 합은 " + result);

		// 3. 반환값이 있는 추상 메소드 처리 : 람다식
		MyInterArgReturn ArgReturn2 = (a, b) -> (a + b);
		System.out.println("두 수의 합은 " + ArgReturn.ccc(3, 4));
	}
}
