package by.rdtc.library.controller.impl.admin;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class UnbanUser implements Command {
	private static final String LOGIN = "login";
	private static final int PARAMS_NUMBER = 1;
	
	private static final Logger log = Logger.getLogger(UnbanUser.class);
	
	@Override
	public String execute(Map<String,String> params) {
		String login=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		
		ServiceFactory sF=ServiceFactory.getInstance();
		AdminService adminService=sF.getAdminService();
		try {
			login=params.get(LOGIN);
			adminService.unbanUser(login);
			response="User "+login+" is unbanned";
		} catch (ServiceException e) {
			log.error(e);
			response="Error during unban procedure";
		}
		return response;
	}
}
