package part5;

import part5.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Part5Section2 {
	public static void main(String[] args) {
		Function<String, Integer> strLength = String::length;
		System.out.println(strLength.apply("Hello world!"));

		BiPredicate<String, String> equalsString = String::equals;
		System.out.println(equalsString.test("Hello", "World"));

		List<User> users = new ArrayList<>();
		users.add(new User(3, "Alice"));
		users.add(new User(1, "Charlie"));
		users.add(new User(5, "Bob"));

		printUserFiled(users, (User user) -> user.getId());
		printUserFiled(users, User::getId);
	}

	public static void printUserFiled(List<User> users, Function<User, Object> getter) {
		for (User user : users) {
			System.out.println(getter.apply(user));
		}
	}
}
