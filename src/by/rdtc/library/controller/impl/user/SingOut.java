package by.rdtc.library.controller.impl.user;

import java.util.Map;

import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.iface.UserService;

public class SingOut implements Command {

	@Override
	public String execute(Map<String,String> params) {
		String response=null;
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		UserService userService=serviceFactory.getUserService();
		Controller.setUser(userService.signOut());
		response="Bye";
		return response;
	}
}
