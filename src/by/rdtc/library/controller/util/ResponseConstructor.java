package by.rdtc.library.controller.util;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.bean.Order;
import by.rdtc.library.bean.User;

public class ResponseConstructor {
	private static final String USER_PROFILE_PATTERN = "login=%s\nname=%s\nsurname=%s\ntype=%s";
	private static final String USER_LIST_PATTERN = "id=%d\tlogin=%s\tname=%s\tsurname=%s\ttype=%s\n";
	private static final String BOOK_LIST_PATTERN = "id=%d\ttitle=%s\tauthor=%s\tstatus=%s\n";
	private static final String ORDER_LIST_PATTERN = "id=%d\tidBook=%s\tdelivery_date=%s\treturn_date=%s\n";
	private static final String USERS_ORDERS_PATTERN = "id=%d\tidUser=%d\tidBook=%d\tdelivery_date=%tF\treturn_date=%tF\n";

	public static String printBookList(List<Book> books) {
		String response = "";
		for (Book book : books) {
			response += String.format(BOOK_LIST_PATTERN, book.getId(), book.getTitle(), book.getAuthor(),
					book.getStatus());
		}
		return response;
	}

	public static String printUserList(List<User> users) {
		String response = "";
		for (User user : users) {
			response += String.format(USER_LIST_PATTERN, user.getId(), user.getLogin(), user.getName(),
					user.getSurname(), user.getType());
		}
		return response;
	}

	public static String printUserProfile(User user) {
		String response = null;
		response = String.format(USER_PROFILE_PATTERN, user.getLogin(), user.getName(), user.getSurname(),
				user.getType());
		return response;
	}

	public static String printOrderList(List<Order> orders) {
		String response = "";
		for (Order order : orders) {
			response += String.format(ORDER_LIST_PATTERN, order.getId(), order.getIdBook(), order.getDeliveryDate(),
					order.getReturnDate());
		}
		return response;
	}

	public static String printBook(Book book) {
		String response = "";
		response += String.format(BOOK_LIST_PATTERN, book.getId(), book.getTitle(), book.getAuthor(), book.getStatus());
		return response;
	}

	public static String printUsersOrders(List<Order> orders) {
		String response = "";
		for (Order order : orders) {
			response += String.format(USERS_ORDERS_PATTERN, order.getId(), order.getIdUser(), order.getIdBook(),
					order.getDeliveryDate(), order.getReturnDate());
		}
		return response;
	}
}
