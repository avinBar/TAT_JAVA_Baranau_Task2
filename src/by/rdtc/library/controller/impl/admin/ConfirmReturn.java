package by.rdtc.library.controller.impl.admin;

import java.util.Map;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class ConfirmReturn implements Command {
	private static final String ID_ORDER="idOrder";
	private static final int PARAMS_NUMBER=1;
	
	@Override
	public String execute(Map<String,String> params) {
		String idOrder=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		idOrder=params.get(ID_ORDER);
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		AdminService adminService=serviceFactory.getAdminService();
		try {
			adminService.confirmReturn(Integer.parseInt(idOrder));
			response="Book is returned";
		} catch (ServiceException e) {
			response="Error during returning procedure";
		}catch (NumberFormatException e){
			response="Invalid parameters";
		}
		
		return response;
	}

}
