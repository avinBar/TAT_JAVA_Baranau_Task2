package by.rdtc.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.impl.AddBook;
import by.rdtc.library.controller.impl.Registration;
import by.rdtc.library.controller.impl.SignIn;
import by.rdtc.library.controller.impl.WrongRequest;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.ADD_BOOK, new AddBook());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
