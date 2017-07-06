package by.rdtc.library.controller.impl.admin;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class DeliveryOrder implements Command {
	
	@Override
	public String execute(String[] param) {
		String response=null;
		String orderId=null;
		
		orderId=param[1];
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		AdminService adminService=serviceFactory.getAdminService();
		try {
			adminService.deliveryOrder(orderId);
			response="The book has been taken away";
		} catch (ServiceException e) {
			response="Error during confirmation order procedure";
		}
		
		return response;
	}
}
