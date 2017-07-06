package by.rdtc.library.controller.impl.admin;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class BanUser implements Command {
	private final String paramDelimeter="&";
	@Override
	public String execute(String request) {
		String response=null;
		String login=null;
		String[] param=request.split(paramDelimeter);
		login=param[1];
		ServiceFactory sF=ServiceFactory.getInstance();
		AdminService adminService=sF.getAdminService();
		try {
			adminService.banUser(login);
			response="Пользователь"+login+" был забанен";
		} catch (ServiceException e) {
			response="Error during ban procedure";
		}
		return response;
	}
}
