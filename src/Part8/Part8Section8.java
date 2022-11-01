package Part8;

import Part8.model.User;
import Part8.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Part8Section8 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);

		// partitioningBy, true인 그룹과 false인 그룹으로 나눔
		Map<Boolean, List<Integer>> numberPartitions = numbers.stream()
				.collect(Collectors.partitioningBy(number -> number % 2 == 0));
		System.out.println(numberPartitions.get(true));
		System.out.println(numberPartitions.get(false));


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

		Map<Boolean, List<User>> userPartitions = users.stream()
				.collect(Collectors.partitioningBy(u -> u.getFriendUserIds().size() > 5));

		EmailService emailService = new EmailService();
		for (User user : userPartitions.get(true)) {
			emailService.sendPlayWithFriendsEmail(user);
		}
		for (User user : userPartitions.get(false)) {
			emailService.sendMakeMoreFriendsEmail(user);
		}
	}
}
