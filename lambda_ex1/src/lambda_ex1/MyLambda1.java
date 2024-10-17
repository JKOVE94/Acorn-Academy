package lambda_ex1;

@FunctionalInterface   //해당 인터페이스는 함수형 인터페이스임을 의미 => 애초에 람다표현식을 사용하겠다는 의미
interface HelloInter {
	int calcData(int a, int b);
//	int calcData2(int a, int b);
}

public class MyLambda1 implements HelloInter{

	@Override
	public int calcData(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println("전통적 방법");
		MyLambda1 my1 = new MyLambda1();
		System.out.println("출력 1 : "+my1.calcData(3, 4));
		
		System.out.println("\n람다 표현식");
		HelloInter inter1 = (int a, int b) -> a+b;
		System.out.println("출력 2 : "+inter1.calcData(3, 4));
		HelloInter inter2 = (int a, int b) -> a*b;
		System.out.println("출력 3 : "+inter2.calcData(3, 4));
	}
	
}
