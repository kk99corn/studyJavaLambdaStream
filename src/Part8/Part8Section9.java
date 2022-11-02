package Part8;

import Part8.model.User;
import Part8.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Part8Section9 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
		numbers.stream().forEach(number -> System.out.println("this number is " + number));
		// stream을 사용하지 않는 경우 forEach 바로 사용 가능
		numbers.forEach(number -> System.out.println("this number is " + number));

		// user 예제
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmailAddress("alice@fast.co.kr")
				.setFriendUserIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214));
		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setVerified(false)
				.setEmailAddress("bob@fast.co.kr")
				.setFriendUserIds(Arrays.asList(204, 205, 206));
		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setVerified(false)
				.setEmailAddress("charlie@fast.co.kr")
				.setFriendUserIds(Arrays.asList(204, 205, 207, 218));
		List<User> users = Arrays.asList(user1, user2, user3);

		EmailService emailService = new EmailService();
		users.stream()
				.filter(u -> !u.isVerified())
				.forEach(emailService::sendVerifyYourEmailEmail);

		// 전통적인 index형 for문 stream에선 어떻게?
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			System.out.println("user name: " + user.getName());
		}
		IntStream.range(0, users.size())
				.forEach(i -> System.out.println(users.get(i).getName()));
	}
}
