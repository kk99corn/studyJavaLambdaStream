package Part8;

import java.util.Optional;
import java.util.stream.Stream;

public class Part8Section3 {
	public static void main(String[] args) {
		// 리스트 데이터 중 음수만 찾아서 아무거나 하나 리턴
		Optional<Integer> anyNegativeInteger = Stream.of(3, 2, -5, 6)
				.filter(x -> x < 0)
				.findAny();
		System.out.println(anyNegativeInteger.get());

		// 리스트 데이터 중 양수만 찾아서 첫번째 값 리턴
		Optional<Integer> firstPositiveInteger = Stream.of(3, 2, -5, 6)
				.filter(x -> x > 0)
				.findFirst();
		System.out.println(firstPositiveInteger.get());
	}
}
