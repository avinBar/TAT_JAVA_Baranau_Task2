package by.rdtc.library.controller.impl.user;

import java.util.Map;

import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.UserService;

public class EditProfile implements Command {
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final int PARAMS_NUMBER=4;
	
	@Override
	public String execute(Map<String, String> params) {
		String name=null;
		String surname=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		name=params.get(NAME);
		surname=params.get(SURNAME);
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		UserService userService=serviceFactory.getUserService();
		try{
			Controller.setUser(userService.editProfile(name, surname));
			response="Profile is updated successfully";
		}catch(ServiceException e){
			response="Error during update profile procedure";
		}
		return response;
	}

}
