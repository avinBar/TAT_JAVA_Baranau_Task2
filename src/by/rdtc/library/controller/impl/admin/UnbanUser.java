package by.rdtc.library.controller.impl.admin;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class UnbanUser implements Command {
	
	@Override
	public String execute(String[] param) {
		String login=null;
		String response=null;
		login=param[1];
		
		ServiceFactory sF=ServiceFactory.getInstance();
		AdminService adminService=sF.getAdminService();
		try {
			adminService.unbanUser(login);
			response="Пользователь "+login+"был разбанен";
		} catch (ServiceException e) {
			response="Error during unban procedure";
		}
		return response;
	}
}
