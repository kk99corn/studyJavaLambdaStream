package part3;

import part3.util.TriFunction;

public class Part3Section4 {
	public static void main(String[] args) {
		/*
		TriFunction<Integer, Integer, Integer, Integer> add = (Integer x, Integer y, Integer z) -> {
			return x + y + z;
		};
		*/

		// 더 단순하게
		TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;

		int result = add.apply(3, 5, 2);
		System.out.println(result);
	}
}
