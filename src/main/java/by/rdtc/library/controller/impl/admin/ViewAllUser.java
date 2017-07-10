package by.rdtc.library.controller.impl.admin;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.bean.User;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.util.ResponseConstructor;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class ViewAllUser implements Command {
	private static final Logger log = Logger.getLogger(ViewAllUser.class);
	
	@Override
	public String execute(Map<String,String> params) {
		String response=null;
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		AdminService adminService=serviceFactory.getAdminService();
		List<User>users;
		try {
			users=adminService.getAllUsers();
			response=ResponseConstructor.printUserList(users);
		} catch (ServiceException e) {
			log.error(e);
			response="Error during view all users procedure";
		}
		return response;
	}

}
