package by.rdtc.library.controller;

import by.rdtc.library.controller.command.Command;

public final class Controller {
	private final CommandProvider provider=new CommandProvider();
	
	private final char paramDelimeter=' ';
	
	public String executeTask(String request){
		String commandName;
		Command executionCommand;
		
		commandName=request.substring(0,request.indexOf(paramDelimeter));
		executionCommand=provider.getCommand(commandName);
		
		String response;
		response=executionCommand.execute(request);
		return response;
	}
}
