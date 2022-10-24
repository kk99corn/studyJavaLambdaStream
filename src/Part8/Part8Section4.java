package Part8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Part8Section4 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
		// 값 합치기
		Optional<Integer> sum = numbers.stream()
				.reduce((x, y) -> x + y);
		System.out.println(sum.get());

		// 최소값 구하기
		Integer min = numbers.stream()
				.reduce((x, y) -> x < y ? x : y)
				.get();
		System.out.println(min);

		Integer reduce = numbers.stream()
				.reduce(1, (x, y) -> x * y);
		System.out.println(reduce);

		List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
		Integer sumStr = numberStrList.stream()
				.map(Integer::parseInt)
				.reduce(0, (x, y) -> x + y);
		System.out.println(sumStr);
	}
}
