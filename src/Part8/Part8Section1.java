package Part8;

import Part6.model.Order;
import Part8.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Part8Section1 {

	public static void main(String[] args) {
		Optional<Integer> max = Stream.of(5, 3, 6, 2, 1)
				.max(Integer::compareTo);
		System.out.println(max);

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
		User user4 = new User()
				.setId(104)
				.setName("David")
				.setVerified(true)
				.setEmailAddress("david@fast.co.kr");
		List<User> users = Arrays.asList(user1, user2, user3);

		User userget = users.stream()
				.min((u1, u2) -> u1.getName().compareTo(u2.getName()))
				.get();
		System.out.println(userget);

		long count = Stream.of(1, -4, 5, -3, 6)
				.filter(x -> x > 0)
				.count();
		System.out.println(count);

		LocalDateTime now = LocalDateTime.now();
		user1.setCreatedAt(now.minusDays(2));
		user2.setCreatedAt(now.minusHours(10));
		user3.setCreatedAt(now.minusHours(1));
		user4.setCreatedAt(now.minusHours(27));
		users = Arrays.asList(user1, user2, user3, user4);

		// 최근 24시간 이내 가입하고, 이메일이 검증되지 않은 숫자는 총 몇?
		long count1 = users.stream()
				.filter(user -> user.getCreatedAt().isAfter(now.minusDays(1)))
				.filter(user -> !user.isVerified())
				.count();
		System.out.println(count1);

		// Order 예제
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

		// TODO: 에러상태인 주문중에서 가격이 가장 비싼 주문 찾기
		Optional<Order> max1 = orders.stream()
				.filter(o -> o.getStatus() == Order.OrderStatus.ERROR)
				.max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()));
		System.out.println(max1);
		BigDecimal bigDecimal = orders.stream()
				.filter(o -> o.getStatus() == Order.OrderStatus.ERROR)
				.max(Comparator.comparing(Order::getAmount))
				.map(Order::getAmount)
				.orElse(BigDecimal.ZERO);
		System.out.println(bigDecimal);
	}
}
