package by.rdtc.library.controller.impl.admin;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class UserToAdmin implements Command{
	private static final String LOGIN = "login";
	private static final int PARAMS_NUMBER = 1;
	
	private static final Logger log = Logger.getLogger(UserToAdmin.class);
	
	@Override
	public String execute(Map<String,String> params) {
		String login=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
				
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		AdminService adminService=serviceFactory.getAdminService();
		try {
			login=params.get(LOGIN);
			adminService.giveAdminRole(login);
			response="User "+login+" is given admin role";
		} catch (ServiceException e) {
			log.error(e);
			response="Error during give admin role procedure";
		}
		return response;
	}
}
