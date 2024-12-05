package stream_ex1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStream1 {
	
	public MyStream1() {
		test1(); //Stream 생성
		test2(); //Stream 적용
		test3(); //Dto 사용
	}
	
	private void test1() {
		//Stream 인터페이스 : 
		//1. Collection(인터페이스)으로 스트림 생성
		// List로 부터 스트림 생성
		
		List<String> list = Arrays.asList("a","b","c");
		Stream<String> listStream = list.stream();
		
		//2. Array로 부터 스트림 생성
		Stream<String> stream1 = Stream.of("a","b","c");
		Stream<String> stream2 = Stream.of(new String[]{"a","b","c"});
		Stream<String> stream3 = Arrays.stream(new String[]{"a","b","c"});
		Stream<String> stream4 = Arrays.stream(new String[]{"a","b","c"},0,3);
		
		//3. 원시 Data로 부터 스트림 생성
		// 5이상 10 미만의 정수를 갖는 IntStream
		IntStream istream = IntStream.range(5, 10);
		istream.forEach(para -> System.out.println(para + ""));
		
	}
	private void test2() {
		List<String> list = Arrays.asList("마리오", "레밍스", "팩맨");
		
		//list.add("소닉"); 배열을 기반으로 List를 만들었을 때 에는 값을 추가할 수 없음, 크기 조절 불가, ReadOnly
		
		//출력
		Iterator<String> iter = list.iterator(); //외부 반복자 사용
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		for(String s : list) { //향상된 for 문
			System.out.println(s);
		}
		System.out.println();
		
		Stream<String> stream = list.stream(); //Stream 객체 생성 (ArrayList가 Stream 객체화)
		stream.forEach(str -> System.out.println(str));
		//stream.forEach(str -> System.out.println(str)); Stream의 포인터가 이미 끝에 도착했기 때문에 'stream has already been operated upon or closed' 에러 발생
		System.out.println();
		list.stream().forEach(str -> System.out.println(str));
		System.out.println();
		list.stream().forEach(System.out::println); //메서드 참조형
		System.out.println();
		System.out.println();
		
		//스트림을 사용하여 chaining(pipe line) 연습
		int hap = IntStream.of(1,3,5,7,9).peek(System.out::println).sum();
		//peek 메소드 : 스트림 각 요소에 대해 지정된 작업을 수행하고 요소 변경 없이 다음으로 자료 전달
		//다양한 작업을 한 번의 스트림에서 연속적으로 수행해야 할 경우 효과적
		System.out.println("합은 :" + hap);

		//메소드 체이닝
		list
		.stream()
		.peek(System.out::println)
		.forEach(System.out::println);
		
		System.out.println("\n-------병렬처리 -----------");
		Stream<String> streamPar = list.parallelStream(); //Collection의 Stream을 병렬모드로 처리 => 대량의 데이터일 때 효과적 -> Thread 운용
		streamPar.forEach(str -> System.out.println(str));
		
		System.out.println("\n-------정렬처리 -----------");
		Stream<String> streamSort = list.stream().sorted(); // 기본은 Ascending sort , 그러나 Comparator.reverseOrder()를 사용하면 Descending sort도 가능하다.
		streamSort.forEach(System.out::print);
		Stream<String> streamSort2 = list.stream().sorted(Comparator.reverseOrder()); // 기본은 Ascending sort , 그러나 Comparator.reverseOrder()를 사용하면 Descending sort도 가능하다.
		streamSort2.forEach(System.out::print);
		
		
	}
	private void test3() {
		List<Student> slist = Arrays.asList(
				new Student("레밍스", "남", 22),
				new Student("팩맨", "남", 25),
				new Student("마리오", "남", 28),
				new Student("피치", "여", 20),
				new Student("마라라", "여", 22)
			);
		Stream<Student> stream = slist.stream();
		stream.forEach(p -> {
			System.out.print(p.getName()+" ");
			System.out.print(p.getGender()+" ");
			System.out.print(p.getAge()+" ");
			System.out.println();
		});
		
		//전체 나이의 평균 - 방법1
		double avg = slist.stream()
				.mapToInt(Student::getAge)
				.average()
				.getAsDouble();
		
		System.out.println("전체 나이 평균 : "+avg);
		
		
		//전체 나이의 평균 - 방법2
		Double avg2 = slist.stream().collect(Collectors.averagingInt(Student::getAge));
		System.out.println("전체 나이 평균 : "+avg2);
		
		//전체 나이의 평균 - 방법3
		OptionalDouble result = slist.stream()
								.mapToInt(Student::getAge)
								.average();
		result.ifPresent(res -> System.out.println("전체 나이 평균 : "+res));
		
		//전체 나이 평균 - 방법 4 필터처리
		double avgM = slist.stream()
				.filter(m -> m.getGender().equals("남")) //필터를 통해서 내용을 거를 수 있음 
				.mapToInt(Student::getAge)
				.average()
				.getAsDouble();
		
		System.out.println("남자 나이 평균 : "+avgM);
	}
	
	//내부 클래스
	class Student{
		private String name;
		private String gender;
		private int age;
		
		public Student(String name, String gender, int age) {
			this.name = name;
			this.gender = gender;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public String getGender() {
			return gender;
		}

		public int getAge() {
			return age;
		}
		
		
	}
	
	public static void main(String[] args) {
		new MyStream1();
	}

}
