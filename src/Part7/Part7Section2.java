package Part7;

import Part7.model.User;

import java.util.Optional;

public class Part7Section2 {
	public static void main(String[] args) {
		// Optional.ifPresent()
		Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(true));
		maybeUser.ifPresent(System.out::println);

		// Optional.map()
		Optional<Integer> maybeId = Optional.ofNullable(maybeGetUser(true))
				.map(User::getId);
		maybeId.ifPresent(System.out::println);

		// Optional.map() 2
		String userName = Optional.ofNullable(maybeGetUser(true))
				.map(User::getName)
				.map(name -> "The name is " + name)
				.orElse("Name is empty");
		System.out.println(userName);
	}

	public static User maybeGetUser(boolean returnUser) {
		if (returnUser) {
			return new User()
					.setId(1001)
					.setName("Alice")
					.setEmailAddress("alice@fastcampus.co.kr")
					.setVerified(false);
		}
		return null;
	}
}
