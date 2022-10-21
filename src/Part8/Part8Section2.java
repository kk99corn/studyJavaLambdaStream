package Part8;

import Part6.model.Order;
import Part8.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Part8Section2 {
	public static void main(String[] args) {
		// 리스트안에 숫자가 모두 0보다 큰지 확인
		List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
		boolean allPositive = numbers.stream()
				.allMatch(x -> x > 0);
		System.out.println(allPositive);

		// 리스트안에 숫자가 하나라도 음수가 있는지 확인
		boolean anyNegative = numbers.stream()
				.anyMatch(x -> x < 0);
		System.out.println(anyNegative);


		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmailAddress("alice@fast.co.kr");
		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setVerified(false)
				.setEmailAddress("bob@fast.co.kr");
		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setVerified(false)
				.setEmailAddress("charlie@fast.co.kr");

		// 전부 검증이된 유저인지 확인
		List<User> users = Arrays.asList(user1, user2, user3);
		boolean areAllUserVerified = users.stream()
				.allMatch(User::isVerified);
		System.out.println(areAllUserVerified);


		// Order 예제
		LocalDateTime now = LocalDateTime.now();
		Order order1 = new Order()
				.setId(1001)
				.setStatus(Order.OrderStatus.CREATED)
				.setCreatedByUserId(101)
				.setAmount(BigDecimal.valueOf(2000))
				.setCreatedAt(now.minusHours(4));
		Order order2 = new Order()
				.setId(1002)
				.setStatus(Order.OrderStatus.ERROR)
				.setCreatedByUserId(103)
				.setAmount(BigDecimal.valueOf(4000))
				.setCreatedAt(now.minusHours(1));
		Order order3 = new Order()
				.setId(1003)
				.setStatus(Order.OrderStatus.ERROR)
				.setCreatedByUserId(102)
				.setAmount(BigDecimal.valueOf(3000))
				.setCreatedAt(now.minusHours(36));
		Order order4 = new Order()
				.setId(1004)
				.setStatus(Order.OrderStatus.PROCESSED)
				.setCreatedByUserId(104)
				.setAmount(BigDecimal.valueOf(7000))
				.setCreatedAt(now.minusHours(40));

		List<Order> orders = Arrays.asList(order1, order2, order3, order4);

		// 하나라도 에러인 상태의 주문이 있는지 확인
		boolean isAnyOrderInErrorStatus = orders.stream()
				.anyMatch(o -> o.getStatus() == Order.OrderStatus.ERROR);
		System.out.println(isAnyOrderInErrorStatus);
	}
}
