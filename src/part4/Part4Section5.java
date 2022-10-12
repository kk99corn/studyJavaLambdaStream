package part4;

import part4.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Part4Section5 {
	public static void main(String[] args) {
		List<User> userList = new ArrayList<>();
		userList.add(new User(3, "Alice"));
		userList.add(new User(1, "Chovy"));
		userList.add(new User(5, "Baker"));

		// 기본 정렬 순서(add 순) 3 -> 1 -> 5
		System.out.println(userList);

		// id로 정렬
		Comparator<User> idComparator = (u1, u2) -> u1.getId() - u2.getId();
		Collections.sort(userList, idComparator);
		System.out.println(userList);

		// name으로 정렬
		Collections.sort(userList, (u1, u2) -> u1.getName().compareTo(u2.getName()));
		System.out.println(userList);
	}
}
