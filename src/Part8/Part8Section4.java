package Part8;

import Part8.model.Order;
import Part8.model.OrderLine;
import Part8.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Part8Section4 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
		// 값 합치기
		Optional<Integer> sum = numbers.stream()
				.reduce((x, y) -> x + y);
		System.out.println(sum.get());

		// 최소값 구하기
		Integer min = numbers.stream()
				.reduce((x, y) -> x < y ? x : y)
				.get();
		System.out.println(min);

		Integer reduce = numbers.stream()
				.reduce(1, (x, y) -> x * y);
		System.out.println(reduce);

		List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
		Integer sumStr = numberStrList.stream()
				.map(Integer::parseInt)
				.reduce(0, (x, y) -> x + y);
		System.out.println(sumStr);

		Integer sumStr2 = numberStrList.stream()
				.reduce(0, ((number, str) -> number + Integer.parseInt(str)), Integer::sum);
		System.out.println(sumStr2);

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
		Optional<Integer> reduce1 = users.stream()
				.map(User::getFriendUserIds)
				.map(List::size)
				.reduce(Integer::sum);
		System.out.println(reduce1.get());


		LocalDateTime now = LocalDateTime.now();
		Order order1 = new Order()
				.setId(1001)
				.setOrderLines(Arrays.asList(
						new OrderLine().setAmount(BigDecimal.valueOf(1000)),
						new OrderLine().setAmount(BigDecimal.valueOf(2000))
				));
		Order order2 = new Order()
				.setId(1002)
				.setOrderLines(Arrays.asList(
						new OrderLine().setAmount(BigDecimal.valueOf(2000)),
						new OrderLine().setAmount(BigDecimal.valueOf(3000))
				));
		Order order3 = new Order()
				.setId(1003)
				.setOrderLines(Arrays.asList(
						new OrderLine().setAmount(BigDecimal.valueOf(1000)),
						new OrderLine().setAmount(BigDecimal.valueOf(2000))
				));
		List<Order> orders = Arrays.asList(order1, order2, order3);

		// 오더들이가지고있는 오더라인 어마운트총합
		BigDecimal reduce2 = orders.stream()
				.map(Order::getOrderLines)
				.flatMap(List::stream)
				.map(OrderLine::getAmount)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(reduce2);
	}
}
