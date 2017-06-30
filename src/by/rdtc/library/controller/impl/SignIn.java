package by.rdtc.library.controller.impl;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.UserService;
import by.rdtc.library.service.exception.ServiceException;

public class SignIn implements Command {
	private final String paramDelimeter=" ";
	
	@Override
	public String execute(String request) {
		String login=null;
		String password=null;
		String response=null;
		String[] param=request.split(paramDelimeter);
		login=param[1];
		password=param[2];
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		UserService userService=serviceFactory.getUserService();
		try{
			userService.signIn(login, password);
			response="Welcome";
		}catch(ServiceException e){
			response="Error during login procedure";
		}
		
		return response;
	}

}
