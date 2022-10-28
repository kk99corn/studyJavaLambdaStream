package Part8;

import Part8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part8Section6 {
	public static void main(String[] args) {
		Map<Integer, String> numberMap = Stream.of(3, 5, -4, 2, 6)
				.collect(Collectors.toMap(x -> x, x -> "Number is " + x));
		System.out.println(numberMap);

	}
}
