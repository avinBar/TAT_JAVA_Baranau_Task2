package by.rdtc.library.controller;

import by.rdtc.library.bean.User;
import by.rdtc.library.controller.command.Command;

public final class Controller {
	private static final String GUEST = "guest";
	private final String paramDelimeter = "&";

	private final CommandProvider provider = new CommandProvider();
	private static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Controller.user = user;
	}

	public String executeTask(String request) {
		String response;
		String commandName;
		Command executionCommand;
		String type;
		String[] param;
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		if (user == null) {
			type=GUEST;
		} else {
			type = getUser().getType();
		}
		executionCommand = provider.getCommand(type, commandName);
		if(executionCommand==null){
			response="В операции отказано";
		}else{
		param=commandName.split(paramDelimeter);
		response = executionCommand.execute(param);}
		return response;
	}
}
