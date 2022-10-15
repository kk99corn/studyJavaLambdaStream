package Part6;

import Part6.model.Order;
import Part6.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part6Section4 {
	public static void main(String[] args) {

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

		// 검증되지 않은 user의 이메일 리스트 조회
		List<String> emails = users.stream()
				.filter(u -> !u.isVerified())
				.map(User::getEmailAddress)
				.collect(Collectors.toList());
		System.out.println(emails);



		// Order 예제
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		Order order1 = new Order()
				.setId(1001)
				.setStatus(Order.OrderStatus.CREATED)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(4));
		Order order2 = new Order()
				.setId(1002)
				.setStatus(Order.OrderStatus.ERROR)
				.setCreatedByUserId(103)
				.setCreatedAt(now.minusHours(1));
		Order order3 = new Order()
				.setId(1003)
				.setStatus(Order.OrderStatus.PROCESSED)
				.setCreatedByUserId(102)
				.setCreatedAt(now.minusHours(36));
		Order order4 = new Order()
				.setId(1004)
				.setStatus(Order.OrderStatus.ERROR)
				.setCreatedByUserId(104)
				.setCreatedAt(now.minusHours(40));
		Order order5 = new Order()
				.setId(1005)
				.setStatus(Order.OrderStatus.IN_PROGRESS)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(10));

		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

		// order중에서 error 상태인 order만 골라내서 userid만 골라내서 반환
		List<Long> userIds = orders.stream()
				.filter(o -> o.getStatus() == Order.OrderStatus.ERROR)
				.map(Order::getCreatedByUserId)
				.collect(Collectors.toList());
		System.out.println(userIds);

		// order중에서 error 상태인 order만 골라내서 24시간 이내 생성인 주문만
		List<Order> ordersInErrorStatusIn24hrs = orders.stream()
				.filter(o -> o.getStatus() == Order.OrderStatus.ERROR)
				.filter(o -> o.getCreatedAt().isAfter(now.minusHours(24)))
				.collect(Collectors.toList());
		System.out.println(ordersInErrorStatusIn24hrs);

	}
}
