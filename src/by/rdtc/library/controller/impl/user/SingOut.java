package by.rdtc.library.controller.impl.user;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.iface.UserService;

public class SingOut implements Command {

	@Override
	public String execute(String request) {
		String response=null;
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		UserService userService=serviceFactory.getUserService();
		userService.signOut();
		response="Bye";
		return response;
	}

}
