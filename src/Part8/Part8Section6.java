package Part8;

import Part8.model.Order;
import Part8.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part8Section6 {
	public static void main(String[] args) {
		Map<Integer, String> numberMap = Stream.of(3, 5, -4, 2, 6)
				.collect(Collectors.toMap(x -> x, x -> "Number is " + x));
		System.out.println(numberMap);

		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmailAddress("alice@fast.co.kr")
				.setFriendUserIds(Arrays.asList(201, 202, 203, 204));
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
				.setFriendUserIds(Arrays.asList(204, 205, 207));
		List<User> users = Arrays.asList(user1, user2, user3);

		Map<Integer, User> userIdToUserMap = users.stream()
				.collect(Collectors.toMap(User::getId, Function.identity()));
		System.out.println(userIdToUserMap);


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
		Map<Long, Part8.model.Order.OrderStatus> orderIdToOrderStatusMap =
				orders.stream()
						.collect(Collectors.toMap(Order::getId, Order::getStatus));

		System.out.println(orderIdToOrderStatusMap);
	}
}
