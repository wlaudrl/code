package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Stream 인터페이스 : 컬렉션, 배열 등 저장 요소를 하나씩 참조하여 인터페이스(람다식)를 적용하며, 반복 처리가 가능 반복자 역할
// 정렬, 집계, 빅데이터 처리 등도 가능 , 1회용 내부 반복으로 작업 처리 , 원본 데이터를 변경하지 않는다
public class MyStram {
	public MyStram() {
		test1(); // Stream 생성
		test2(); // 컬렉션에 스트림 적용
		test3(); // VO 클래스 사용

	}

	private void test1() {
		// 1) collection 의 스트림 생성
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> listStram = list.stream();

		// 2) 배열의 스트림 생성
		Stream<String> stream1 = Stream.of("a", "b", "c");
		Stream<String> stream2 = Stream.of(new String[] { "a", "b", "c" });
		Stream<String> stream3 = Arrays.stream(new String[] { "a", "b", "c" });
		Stream<String> stream4 = Arrays.stream(new String[] { "a", "b", "c" }, 0, 3);

		// 3) 원시(데이터) Stream 생성
		IntStream istream = IntStream.range(5, 10);
//		DoubleStream ...
		istream.forEach(para -> System.out.println(para + " "));

		System.out.println();
	}

	private void test2() {
		List<String> list = Arrays.asList("레밍스", "팩맨", "마리오");
//		list.add("소닉"); // 새로운 요소 추가 X, 기존 요소 삭제 X
		Iterator<String> iter = list.iterator(); // 외부 반복자 사용. (전통적)
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		for (String str : list) { // 향상된 for 문 사용 (전통적)
			System.out.println(str);

		}
		for (String str : list) { // 향상된 for 문 사용 (전통적)
			System.out.println(str);
		}
		System.out.println();
		Stream<String> stream = list.stream(); // Stream 객체를 생성
		stream.forEach(str -> System.out.println(str)); // 내부 반복으로 작업 처리
//		stream.forEach(str -> System.out.println(str)); // err : 1회용

		list.stream().forEach(str -> System.out.println(str)); // Stream 객체 생성 후 출력
		list.stream().forEach(System.out::println); // Stream 에서 람다 표현 방법

		System.out.println();
		// 스트림을 사용하여 체이닝 작업 : 모든 필요한 작업을 단일 스트림 파이프라인(일련의 처리 단계)에서 처리 가능
		// 어떤 스트림의 요소들의 합을 구하는 과정에서 요소 값을 먼저 출력하고 싶은 경우
		int sum = IntStream.of(1, 3, 5, 7).peek(System.out::println).sum(); // count,max....
		System.out.println("합은 " + sum);

		list.stream().peek(System.out::println).forEach(System.out::println);

		System.out.println("\n병렬 처리");
		Stream<String> streamPar = list.parallelStream(); // 병렬Stream 객체 생성
		streamPar.forEach(str -> System.out.println(str));

		System.out.println("\n정렬 처리");
		Stream<String> streamSort = list.stream().sorted(); // ascending(오름차순)
		Stream<String> streamSort2 = list.stream().sorted(Comparator.reverseOrder()); // 내림차순
		streamSort.forEach(System.out::println);
		streamSort2.forEach(System.out::println);

		Stream<String> streamSort3 = list.stream().distinct().sorted(); // 중복 제거

	}

	private void test3() {
		System.out.println("\n\nVO 클래스로 컬렉션 작성");
		List<Student> slist = Arrays.asList(new Student("레밍", "남", 22), new Student("팩맨", "남", 25),
				new Student("마리오", "남", 28), new Student("피치", "여", 20), new Student("마라라", "여", 22));

		Stream<Student> stream = slist.stream();
		stream.forEach(p -> {
			System.out.println(p.getName() + " " + p.getGender() + " " + p.getAge());
		});

		System.out.println("컬렉션 자료에 대한 중간 처리, 최종 처리가 가능");
		// 각 개인의 나이를 츌력하고, 최종 나이의 평균 출력
		// 방법1)
		double avg = slist.stream() // stream 객체 생성
				.mapToInt(Student::getAge) // student 객체 age 값으로 매핑해 age 로 새 스트림 생성
				.average() // 내부적으로 age 요소의 평균을 OptionalDouble에 저장 값이 없을 수도 있다는 가정
				.getAsDouble(); // OptionalDouble에 저장된 값 읽기
		System.out.println("나이 전체 평균은" + avg);

		// 방법2)
		Double avg2 = slist.stream().collect(Collectors.averagingInt(Student::getAge));
		System.out.println("나이 전체 평균은" + avg2);

		// 방법3)
		OptionalDouble result = slist.stream().mapToDouble(Student::getAge).average();
		result.ifPresent(res -> System.out.println("나이 전체 평균은" + res));
		
		// 필터 처리
		// 남자 나이 평균
		// OptionalDouble에 저장된 값 읽기
		double avgM = slist.stream().filter(m -> m.getGender().equals("남")).mapToInt(Student::getAge).average()
				.getAsDouble();
		System.out.println("남자 나이 평균 : " + avgM);

		// '마' 성을 가진 자료 출력
		slist.stream().filter(ir -> ir.getName().startsWith("마")).forEach(irum -> System.out.println(irum.getName()));

	}

	// 내부 클래스
	class Student {
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
		new MyStram();

	}
}
