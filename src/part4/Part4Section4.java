package part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Part4Section4 {
	public static void main(String[] args) {
		Predicate<Integer> predicate = x -> x > 0;
		System.out.println(predicate.test(10));

		List<Integer> inputs = Arrays.asList(1, 5, -1, 9, -1111, 123, -99999, 0);

		// basic
		System.out.println("basic: " + filter(inputs, predicate));

		// negate (not 연산)
		System.out.println("nagate: " + filter(inputs, predicate.negate()));

		// or
		System.out.println("or: " + filter(inputs, predicate.or(x -> x == 0)));

		// and
		System.out.println("and: " + filter(inputs, predicate.and(x -> x > 100)));
	}

	public static <T> List<T> filter(List<T> inputList, Predicate<T> conditions) {
		List<T> result = new ArrayList<>();
		for (T input : inputList) {
			if (conditions.test(input)) {
				result.add(input);
			}
		}
		return result;
	}
}
