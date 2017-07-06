package by.rdtc.library.controller.impl.admin;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class ConfirmReturn implements Command {
	private final String paramDelimeter="&";
	@Override
	public String execute(String request) {
		String response=null;
		String orderId=null;
		String[] param=request.split(paramDelimeter);
		orderId=param[1];
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		AdminService adminService=serviceFactory.getAdminService();
		try {
			adminService.confirmReturn(orderId);
			response="Book was returned";
		} catch (ServiceException e) {
			response="Error during returning procedure";
		}
		
		return response;
	}

}
