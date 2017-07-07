package by.rdtc.library.controller;

import java.util.Map;

import by.rdtc.library.bean.User;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.util.RequestParser;

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
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		if (user == null) {
			type=GUEST;
		} else {
			type = getUser().getType();
		}
		Map<String, String> paramsMap = RequestParser.getParameters(request);
		executionCommand = provider.getCommand(type, commandName);
		if(executionCommand==null){
			response="Not allowed to execute procedure";
		}else{
		response = executionCommand.execute(paramsMap);}
		return response;
	}
}
