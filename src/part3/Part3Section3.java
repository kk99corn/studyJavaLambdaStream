package part3;

import java.util.function.BiFunction;

public class Part3Section3 {
	public static void main(String[] args) {
		/*
		BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> {
			return x + y;
		};
		*/

		// 더 단순하게
		BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

		int result = add.apply(3, 5);
		System.out.println(result);
	}
}
