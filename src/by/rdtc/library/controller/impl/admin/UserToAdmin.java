package by.rdtc.library.controller.impl.admin;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class UserToAdmin implements Command{
	
	@Override
	public String execute(String[] param) {
		String response=null;
		String login=null;
		login=param[1];
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		AdminService adminService=serviceFactory.getAdminService();
		try {
			adminService.giveAdminRole(login);
			response="Пользователь "+login+" теперь Админ";
		} catch (ServiceException e) {
			response="Error during giving admin role procedure";
		}
		return response;
	}
}
