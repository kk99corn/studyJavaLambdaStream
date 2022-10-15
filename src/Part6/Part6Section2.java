package Part6;

import Part6.model.Order;
import Part6.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part6Section2 {
	public static void main(String[] args) {
		Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);

		// 양수만 걸러내는 filter
		Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);

		// stream to list
		List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
		System.out.println(filteredNumbers);

		// 간소화
		List<Integer> newFilteredNumbers = Stream.of(3, -5, 7, 10, -3)
				.filter(x -> x > 0)
				.collect(Collectors.toList());
		System.out.println(newFilteredNumbers);



		// User 예제
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmailAddress("alice@fastcampus.co.kr");

		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setVerified(false)
				.setEmailAddress("Bob@fastcampus.co.kr");

		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setVerified(true)
				.setEmailAddress("Charlie@fastcampus.co.kr");

		// 검증된 유저만 filter
		List<User> users = Arrays.asList(user1, user2, user3);
		List<User> verifiedUsers = users.stream()
				.filter(User::isVerified)
				.collect(Collectors.toList());
		System.out.println(verifiedUsers);

		// 검증되지 않은 유저만 filter
		List<User> unVerifiedUsers = users.stream()
				.filter(user -> !user.isVerified())
				.collect(Collectors.toList());
		System.out.println(unVerifiedUsers);



		// Order 예제
		Order order1 = new Order()
				.setId(1001)
				.setStatus(Order.OrderStatus.CREATED);
		Order order2 = new Order()
				.setId(1002)
				.setStatus(Order.OrderStatus.ERROR);
		Order order3 = new Order()
				.setId(1003)
				.setStatus(Order.OrderStatus.PROCESSED);
		Order order4 = new Order()
				.setId(1004)
				.setStatus(Order.OrderStatus.ERROR);
		Order order5 = new Order()
				.setId(1005)
				.setStatus(Order.OrderStatus.IN_PROGRESS);

		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
		// Filter orders in ERROR state
		List<Order> errorOrders = orders.stream()
				.filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
				.collect(Collectors.toList());
		System.out.println(errorOrders);
	}
}
