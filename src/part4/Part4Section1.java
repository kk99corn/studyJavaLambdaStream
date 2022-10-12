package part4;

import java.util.function.Supplier;

public class Part4Section1 {
	public static void main(String[] args) {
		Supplier<String> myStringSupplier = () -> "hello word";
		System.out.println(myStringSupplier.get());

		Supplier<Double> myRandomSupplier = Math::random;
		System.out.println(myRandomSupplier.get());
		System.out.println(myRandomSupplier.get());
		System.out.println(myRandomSupplier.get());
		System.out.println("-----------------------");
		printRandomDoubles(myRandomSupplier, 5);
	}

	/**
	 * Supplier를 파라미터 인자로 사용
	 *
	 * @param randomSup Supplier
	 * @param count 반복횟수
	 */
	public static void printRandomDoubles(Supplier<Double> randomSup, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(randomSup.get());
		}
	}
}
