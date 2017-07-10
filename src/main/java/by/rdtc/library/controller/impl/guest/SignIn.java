package by.rdtc.library.controller.impl.guest;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.UserService;

public class SignIn implements Command {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final int PARAMS_NUMBER = 2;
	
	private static final Logger log = Logger.getLogger(SignIn.class);
	
	@Override
	public String execute(Map<String,String> params) {
		String login=null;
		String password=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		UserService userService=serviceFactory.getUserService();
		try{
			login=params.get(LOGIN);
			password=params.get(PASSWORD);
			Controller.setUser(userService.signIn(login, password));
			response="Welcome "+login;
		}catch(ServiceException e){
			log.error(e);
			response="Error during sign_in procedure";
		}
		return response;
	}
}
