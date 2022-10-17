package Part6;

import Part6.model.Order;
import Part6.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part6Section7 {
	public static void main(String[] args) {
		String[][] cities = new String[][]{
				{"Seoul", "Busan"},
				{"San Francisco", "New York"},
				{"Madrid", "Barcelona"}
		};

		// String array를 가진 Stream
		Stream<String[]> cityStream = Arrays.stream(cities);
		Stream<Stream<String>> cityStreamStream = cityStream.map(Arrays::stream);
		List<Stream<String>> cityStreamList = cityStreamStream.collect(Collectors.toList());

		// flatMap 변환
		Stream<String[]> cityStream2 = Arrays.stream(cities);
		List<String> cityList = cityStream2.flatMap(Arrays::stream).collect(Collectors.toList());
		System.out.println(cityList);

		Order order1 = new Order()
				.setId(1001)
				.setOrderLines(Arrays.asList(
						new OrderLine()
								.setId(10001)
								.setType(OrderLine.OrderLineType.PURCHASE)
								.setAmount(BigDecimal.valueOf(5000)),
						new OrderLine()
								.setId(10002)
								.setType(OrderLine.OrderLineType.PURCHASE)
								.setAmount(BigDecimal.valueOf(4000))
				));

		Order order2 = new Order()
				.setId(1002)
				.setOrderLines(Arrays.asList(
						new OrderLine()
								.setId(10003)
								.setType(OrderLine.OrderLineType.PURCHASE)
								.setAmount(BigDecimal.valueOf(2000)),
						new OrderLine()
								.setId(10004)
								.setType(OrderLine.OrderLineType.DISCOUNT)
								.setAmount(BigDecimal.valueOf(-1000))
				));

		Order order3 = new Order()
				.setId(1003)
				.setOrderLines(Arrays.asList(
						new OrderLine()
								.setId(10005)
								.setType(OrderLine.OrderLineType.PURCHASE)
								.setAmount(BigDecimal.valueOf(2000))
				));

		List<Order> orders = Arrays.asList(order1, order2, order3);
		List<OrderLine> mergedOrderLines = orders.stream()
				.map(Order::getOrderLines)
				.flatMap(List::stream)
				.collect(Collectors.toList());
		System.out.println(mergedOrderLines);
	}
}
