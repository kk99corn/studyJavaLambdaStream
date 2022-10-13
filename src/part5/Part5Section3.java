package part5;

import part4.model.Car;
import part4.model.Sedan;
import part4.model.Suv;
import part4.model.Van;
import part5.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Part5Section3 {
	public static void main(String[] args) {
		User user = new User(1, "Alice");

		// BiFunction<Integer, String, User> userCreator = (id, name) -> new User(id, name);
		BiFunction<Integer, String, User> userCreator = User::new;
		User charlie = userCreator.apply(3, "Charlie");

		String[][] inputs = new String[][]{
				{"sedan", "Sonata", "Hyundai"},
				{"van", "Sienna", "Toyota"},
				{"sedan", "Model S", "Tesla"},
				{"suv", "Sorento", "Kia"}
		};

		Map<String, BiFunction<String, String, Car>> carTypeMap = new HashMap<>();
		carTypeMap.put("sedan", Sedan::new);
		carTypeMap.put("suv", Suv::new);
		carTypeMap.put("van", Van::new);

		List<Car> cars = new ArrayList<>();
		for (String[] input : inputs) {
			String carType = input[0];
			String name = input[1];
			String brand = input[2];

			cars.add(carTypeMap.get(carType).apply(name, brand));
		}

		for (Car car : cars) {
			car.drive();
		}
	}
}
