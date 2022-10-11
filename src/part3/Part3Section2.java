package part3;

import java.util.function.Function;

public class Part3Section2 {
	public static void main(String[] args) {
		/*
		Function<Integer, Integer> myAdder = (Integer x) -> {
			return x + 10;
		};
		*/

		// 더 단순하게
		Function<Integer, Integer> myAdder = x -> x + 10;

		int apply = myAdder.apply(10);
		System.out.println(apply);
	}
}
