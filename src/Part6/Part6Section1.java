package Part6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part6Section1 {
	public static void main(String[] args) {
		// stream to list(Collectors.toList())
		// 스트림에 있는 데이터 출력하는 방법(리스트로 변경)
		Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
		List<String> nameCollect = nameStream.collect(Collectors.toList());
		System.out.println(nameCollect);

		// array to stream(Arrays.stream())
		String[] cityArr = new String[]{"San Jose", "Seoul", "Tokyo"};
		Stream<String> cityStream = Arrays.stream(cityArr);
		List<String> cityCollect = cityStream.collect(Collectors.toList());
		System.out.println(cityCollect);

		// collection to stream(Set.stream())
		Set<Integer> numberSet = new HashSet<>(Arrays.asList(3, 5, 7));
		Stream<Integer> numberStream = numberSet.stream();
		List<Integer> numberCollect = numberStream.collect(Collectors.toList());
		System.out.println(numberCollect);
	}
}
