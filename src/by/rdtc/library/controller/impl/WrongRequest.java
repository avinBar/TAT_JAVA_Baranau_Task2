package by.rdtc.library.controller.impl;

import by.rdtc.library.controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(String request) {
		String response="Неправильный запрос";
		return response;
	}

}
