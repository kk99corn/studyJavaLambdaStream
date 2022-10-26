package Part8;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part8Section5 {
	public static void main(String[] args) {
		// Collectors.toList()
		List<Integer> numberList = Stream.of(3, 5, -3, 3, 4, 5)
				.collect(Collectors.toList());
		System.out.println(numberList);

		// Collectors.toSet()
		Set<Integer> numberSet = Stream.of(3, 5, -3, 3, 4, 5)
				.collect(Collectors.toSet());
		System.out.println(numberSet);

		// Collectors.mapping()
		List<Integer> numberList2 = Stream.of(3, 5, -3, 3, 4, 5)
				.collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
		System.out.println(numberList2);

		// Collectors.mapping()
		Set<Integer> numberSet2 = Stream.of(3, 5, -3, 3, 4, 5)
				.collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
		System.out.println(numberSet2);

		// Collectors.reducing()
		Integer sum = Stream.of(3, 5, -3, 3, 4, 5)
				.collect(Collectors.reducing(0, (x, y) -> x + y));
		System.out.println(sum);
	}
}
