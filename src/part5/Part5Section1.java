package part5;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Part5Section1 {
	public static void main(String[] args) {
		// 1-a. 클래스의 static method를 지정할 때
		Function<String, Integer> str2Int = Integer::parseInt;
		System.out.println(str2Int.apply("111"));

		// 1-b. 클래스의 static method를 지정할 때
		System.out.println(calculate(8, 2, Part5Section1::multiply));

		// 2. 선언 된 객체의 instance method를 지정할 때
		String str = "hello";
		Predicate<String> strEquals = str::equals;
		System.out.println(strEquals.test("world"));

		Part5Section1 part5Section1 = new Part5Section1();
		System.out.println(calculate(8, 2, part5Section1::subtract));
		part5Section1.myMethod();
	}

	public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
		return operator.apply(x, y);
	}

	public static int multiply(int x, int y) {
		return x * y;
	}

	public int subtract(int x, int y) {
		return x - y;
	}

	public void myMethod() {
		System.out.println(calculate(111, 1111, this::subtract));
	}
}
