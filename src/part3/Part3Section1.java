package part3;

import part3.util.Adder;

import java.util.function.Function;

public class Part3Section1 {
	public static void main(String[] args) {
		Function<Integer, Integer> adder = new Adder();
		int apply = adder.apply(10);
		System.out.println(apply);
	}
}
