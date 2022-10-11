package part3.util;

import java.util.function.Function;

public class Adder implements Function<Integer, Integer> {
	@Override
	public Integer apply(Integer i) {
		return i + 10;
	}
}
