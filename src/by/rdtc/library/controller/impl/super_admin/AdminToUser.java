package by.rdtc.library.controller.impl.super_admin;

import java.util.Map;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.SuperAdminService;

public class AdminToUser implements Command {
	private static final String LOGIN = "login";
	private static final int PARAMS_NUMBER = 1;
	
	@Override
	public String execute(Map<String,String> params) {
		String login=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		login=params.get(LOGIN);
		
		ServiceFactory sF=ServiceFactory.getInstance();
		SuperAdminService superAdminService=sF.getSuperAdminService();
		try {
			superAdminService.removeAdmin(login);
			response="User"+login+" is deprived of admin role";
		} catch (ServiceException e) {
			response="Error during unban procedure";
		}
		return response;
	}
}
