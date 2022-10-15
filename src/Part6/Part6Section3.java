package Part6;

import Part6.model.Order;
import Part6.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part6Section3 {
	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(3, 6, -4);
		// list to stream
		Stream<Integer> numberStream = numberList.stream();
		// stream.map
		Stream<Integer> numberStreamX2 = numberStream.map(x -> x * 2);
		// stream to list
		List<Integer> numberListX2 = numberStreamX2.collect(Collectors.toList());

		// 간소화
		List<Integer> numbersX2 = numberList.stream()
				.map(x -> x * 2)
				.collect(Collectors.toList());
		System.out.println(numbersX2);

		// return String
		Stream<Integer> numberListStream = numberList.stream();
		Stream<String> strStream = numberListStream.map(x -> "Number is " + x);
		List<String> strList = strStream.collect(Collectors.toList());
		System.out.println(strList);



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

		List<User> users = Arrays.asList(user1, user2, user3);

		// User object에서 email정보만 가져오기
		Stream<String> userEmailStream = users.stream()
				.map(User::getEmailAddress);
		List<String> emailAddresses = userEmailStream.collect(Collectors.toList());
		System.out.println(emailAddresses);



		// Order 예제
		Order order1 = new Order()
				.setId(1001)
				.setStatus(Order.OrderStatus.CREATED)
				.setCreatedByUserId(101);
		Order order2 = new Order()
				.setId(1002)
				.setStatus(Order.OrderStatus.ERROR)
				.setCreatedByUserId(103);
		Order order3 = new Order()
				.setId(1003)
				.setStatus(Order.OrderStatus.PROCESSED)
				.setCreatedByUserId(102);
		Order order4 = new Order()
				.setId(1004)
				.setStatus(Order.OrderStatus.ERROR)
				.setCreatedByUserId(104);
		Order order5 = new Order()
				.setId(1005)
				.setStatus(Order.OrderStatus.IN_PROGRESS)
				.setCreatedByUserId(101);

		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

		// orderlist에서 어떤 user가 만들었는지 user id만 추출하기기
		List<Long> createdByUserIds = orders.stream()
				.map(Order::getCreatedByUserId)
				.collect(Collectors.toList());
		System.out.println(createdByUserIds);

	}
}
