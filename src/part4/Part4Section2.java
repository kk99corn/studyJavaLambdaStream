package part4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Part4Section2 {
	public static void main(String[] args) {
		// Consumer<String> stringConsumer = (str) -> System.out.println(str);
		Consumer<String> stringConsumer = System.out::println;
		stringConsumer.accept("ssssssss");

		Consumer<Integer> integerConsumer = x -> System.out.println("Processing integer: " + x);
		List<Integer> integerInputs = Arrays.asList(4, 2, 3);
		process(integerInputs, integerConsumer);
		processGeneric(integerInputs, integerConsumer);

		Consumer<Double> doubleConsumer = x -> System.out.println("Processing double: " + x);
		List<Double> doubleInputs = Arrays.asList(4.2, 2.3, 3.9);
		processGeneric(doubleInputs, doubleConsumer);
	}

	public static void process(List<Integer> inputs, Consumer<Integer> processor) {
		for (Integer input : inputs) {
			processor.accept(input);
		}
	}

	// 제네릭을 이용하여, 여러 타입에 대한 지원
	public static <A> void processGeneric(List<A> inputs, Consumer<A> processor) {
		for (A input : inputs) {
			processor.accept(input);
		}
	}
}
