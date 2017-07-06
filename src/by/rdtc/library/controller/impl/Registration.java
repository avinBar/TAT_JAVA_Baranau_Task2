package by.rdtc.library.controller.impl;

import by.rdtc.library.bean.User;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.UserService;
import by.rdtc.library.service.exception.ServiceException;

public class Registration implements Command {

	@Override
	public String execute(String request) {
		//String login=null;
		//String password=null;
		//String name=null;
		String response=null;
		
		String[] param=request.split(" ");
		System.out.println(param[1]+" "+param[2]+" "+param[3]);
		ServiceFactory service=ServiceFactory.getInstance();
		UserService userService=service.getUserService();
		User user=new User(param[1],param[2],param[3]);
		try {
			userService.registration(user);
			response="Successful registration";
		} catch (ServiceException e) {
			response="Error during registration procedure";
		}
		return response;
	}

}
