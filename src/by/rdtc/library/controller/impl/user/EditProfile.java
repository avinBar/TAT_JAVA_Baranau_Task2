package by.rdtc.library.controller.impl.user;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.bean.User;
import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.UserService;

public class EditProfile implements Command {
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final int PARAMS_NUMBER=2;
	
	private static final Logger log = Logger.getLogger(EditProfile.class);
	
	@Override
	public String execute(Map<String, String> params) {
		int idUser;
		String name=null;
		String surname=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		idUser=Controller.getUser().getId();
		name=params.get(NAME);
		surname=params.get(SURNAME);
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		UserService userService=serviceFactory.getUserService();
		User user;
		try{
			user=new User(idUser,name,surname);
			userService.editProfile(user);
			response="Profile is updated successfully";
		}catch(ServiceException e){
			log.error(e);
			response="Error during edit profile procedure";
		}
		return response;
	}

}
