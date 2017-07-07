package by.rdtc.library.controller.impl.guest;

import java.util.Map;

import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.UserService;

public class SignIn implements Command {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final int PARAMS_NUMBER = 2;
	
	@Override
	public String execute(Map<String,String> params) {
		String login=null;
		String password=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		login=params.get(LOGIN);
		password=params.get(PASSWORD);
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		UserService userService=serviceFactory.getUserService();
		try{
			Controller.setUser(userService.signIn(login, password));
			response="Welcome "+Controller.getUser().getLogin();
		}catch(ServiceException e){
			response="Error during login procedure";
		}
		return response;
	}
}
