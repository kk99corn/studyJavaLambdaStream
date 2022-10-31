package Part8;

import Part8.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Part8Section7 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
		Map<Integer, List<Integer>> unitDigitMap = numbers.stream()
				.collect(Collectors.groupingBy(number -> number % 10));
		System.out.println(unitDigitMap);

		Map<Integer, Set<Integer>> unitDigitSet = numbers.stream()
				.collect(Collectors.groupingBy(n -> n % 10, Collectors.toSet()));
		System.out.println(unitDigitSet);


		Map<Integer, List<String>> unitDigitStrMap = numbers.stream()
				.collect(Collectors.groupingBy(n -> n % 10, Collectors.mapping(n -> "unit digit is " + n, Collectors.toList())));
		System.out.println(unitDigitStrMap);


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

		Map<Order.OrderStatus, List<Order>> orderStatusMap = orders.stream()
				.collect(Collectors.groupingBy(Order::getStatus));
		System.out.println(orderStatusMap);

		Map<Order.OrderStatus, BigDecimal> orderStatusSumOfAmountMap = orders.stream()
				.collect(Collectors.groupingBy(Order::getStatus,
						Collectors.mapping(Order::getAmount,
								Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
		System.out.println(orderStatusSumOfAmountMap);
	}
}
