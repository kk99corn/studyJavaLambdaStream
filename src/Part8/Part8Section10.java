package Part8;

import Part8.model.User;
import Part8.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part8Section10 {
	public static void main(String[] args) {

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
		User user4 = new User()
				.setId(104)
				.setName("David")
				.setVerified(true)
				.setEmailAddress("david@fast.co.kr")
				.setFriendUserIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214));
		User user5 = new User()
				.setId(105)
				.setName("Eve")
				.setVerified(false)
				.setEmailAddress("eve@fast.co.kr")
				.setFriendUserIds(Arrays.asList(204, 205, 206));
		User user6 = new User()
				.setId(106)
				.setName("Frank")
				.setVerified(false)
				.setEmailAddress("frank@fast.co.kr")
				.setFriendUserIds(Arrays.asList(204, 205, 207, 218));
		List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

		// 시퀀셜
		long startTime = System.currentTimeMillis();
		EmailService emailService = new EmailService();
		users.stream()
				.filter(u -> !u.isVerified())
				.forEach(emailService::sendVerifyYourEmailEmail);
		long endTime = System.currentTimeMillis();
		System.out.println("Sequential: " + (endTime - startTime) + "ms");

		// 패러럴(병렬)
		startTime = System.currentTimeMillis();
		users.stream().parallel()
				.filter(u -> !u.isVerified())
				.forEach(emailService::sendVerifyYourEmailEmail);
		endTime = System.currentTimeMillis();
		System.out.println("Parallel: " + (endTime - startTime) + "ms");

		List<User> processedUser = users.parallelStream()
				.map(u -> {
					System.out.println("Capitalize user name for user " + u.getId());
					u.setName(u.getName().toUpperCase());
					return u;
				})
				.map(u -> {
					System.out.println("Set verified " + u.getId());
					u.setVerified(true);
					return u;
				})
				.collect(Collectors.toList());
		System.out.println(processedUser);
	}
}
