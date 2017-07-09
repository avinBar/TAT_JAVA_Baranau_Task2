package by.rdtc.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.impl.WrongRequest;
import by.rdtc.library.controller.impl.admin.AddBook;
import by.rdtc.library.controller.impl.admin.BanUser;
import by.rdtc.library.controller.impl.admin.ConfirmReturn;
import by.rdtc.library.controller.impl.admin.DeleteBook;
import by.rdtc.library.controller.impl.admin.DeliveryOrder;
import by.rdtc.library.controller.impl.admin.EditBook;
import by.rdtc.library.controller.impl.admin.UnbanUser;
import by.rdtc.library.controller.impl.admin.UserToAdmin;
import by.rdtc.library.controller.impl.admin.ViewAllUser;
import by.rdtc.library.controller.impl.admin.ViewUsersOrders;
import by.rdtc.library.controller.impl.guest.Registration;
import by.rdtc.library.controller.impl.guest.ShowBooks;
import by.rdtc.library.controller.impl.guest.SignIn;
import by.rdtc.library.controller.impl.super_admin.AdminToUser;
import by.rdtc.library.controller.impl.user.CancelOrder;
import by.rdtc.library.controller.impl.user.EditProfile;
import by.rdtc.library.controller.impl.user.OrderBook;
import by.rdtc.library.controller.impl.user.ShowProfile;
import by.rdtc.library.controller.impl.user.SingOut;
import by.rdtc.library.controller.impl.user.ViewBook;
import by.rdtc.library.controller.impl.user.ViewOrders;

final class CommandProvider {
	private static final String USER = "user";
	private static final String ADMIN = "admin";
	private static final String SUPER_ADMIN = "super_admin";

	private final Map<CommandName, Command> adminCommands = new HashMap<>();
	private final Map<CommandName, Command> superAdminCommands = new HashMap<>();
	private final Map<CommandName, Command> userCommands = new HashMap<>();
	private final Map<CommandName, Command> guestCommands = new HashMap<>();

	CommandProvider() {
		guestCommands.put(CommandName.SIGN_IN, new SignIn());
		guestCommands.put(CommandName.SHOW_BOOKS, new ShowBooks());
		guestCommands.put(CommandName.REGISTER, new Registration());
		guestCommands.put(CommandName.WRONG_REQUEST, new WrongRequest());

		userCommands.putAll(guestCommands);
		userCommands.put(CommandName.SIGN_OUT, new SingOut());
		userCommands.put(CommandName.SHOW_PROFILE, new ShowProfile());
		userCommands.put(CommandName.EDIT_PROFILE, new EditProfile());
		userCommands.put(CommandName.VIEW_BOOK, new ViewBook());
		userCommands.put(CommandName.ORDER_BOOK, new OrderBook());
		userCommands.put(CommandName.CANCEL_ORDER, new CancelOrder());
		userCommands.put(CommandName.VIEW_ORDERS, new ViewOrders());

		adminCommands.putAll(userCommands);
		adminCommands.put(CommandName.ADD_BOOK, new AddBook());
		adminCommands.put(CommandName.EDIT_BOOK, new EditBook());
		adminCommands.put(CommandName.DELETE_BOOK, new DeleteBook());
		adminCommands.put(CommandName.BAN_USER, new BanUser());
		adminCommands.put(CommandName.UNBAN_USER, new UnbanUser());
		adminCommands.put(CommandName.VIEW_ALL_USERS, new ViewAllUser());
		adminCommands.put(CommandName.GIVE_ADMIN_ROLE, new UserToAdmin());
		adminCommands.put(CommandName.VIEW_USERS_ORDERS, new ViewUsersOrders());
		adminCommands.put(CommandName.DELIVERY_ORDER, new DeliveryOrder());
		adminCommands.put(CommandName.RETURN_BOOK, new ConfirmReturn());

		superAdminCommands.putAll(adminCommands);
		superAdminCommands.put(CommandName.REMOVE_ADMIN, new AdminToUser());

	}

	Command getCommand(String type, String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			switch (type) {
			case USER:
				return userCommands.get(commandName);
			case ADMIN:
				return adminCommands.get(commandName);
			case SUPER_ADMIN:
				return superAdminCommands.get(commandName);
			default:
				return guestCommands.get(commandName);
			}
		}catch (IllegalArgumentException | NullPointerException e) {
			command = guestCommands.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
