package by.rdtc.library.controller.impl;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.SuperAdminService;
import by.rdtc.library.service.exception.ServiceException;

public class AdminToUser implements Command {
	private final String paramDelimeter=" ";
	@Override
	public String execute(String request) {
		String response=null;
		String login=null;
		String[] param=request.split(paramDelimeter);
		login=param[1];
		ServiceFactory sF=ServiceFactory.getInstance();
		SuperAdminService superAdminService=sF.getSuperAdminService();
		try {
			superAdminService.takeAdminRole(login);
			response="User"+login+"was unbanned";
		} catch (ServiceException e) {
			response="Error during unban procedure";
		}
		return response;
	}
}
