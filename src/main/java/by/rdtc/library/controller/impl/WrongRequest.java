package by.rdtc.library.controller.impl;

import java.util.Map;

import by.rdtc.library.controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(Map<String, String> params) {
		String response="Wrong command";
		return response;
	}

}
