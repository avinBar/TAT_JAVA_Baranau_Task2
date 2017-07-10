package by.rdtc.library.controller.impl.user;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.bean.User;
import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.util.ResponseConstructor;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.UserService;

public class ShowProfile implements Command {
	private static final Logger log = Logger.getLogger(ShowProfile.class);
	
	@Override
	public String execute(Map<String, String> params) {
		int idUser;
		
		String response=null;
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		UserService userService=serviceFactory.getUserService();
		User user;
		try{
			idUser=Controller.getUser().getId();
			user=userService.getUserByID(idUser);
			response=ResponseConstructor.printUserProfile(user);
		}catch(ServiceException e){
			log.error(e);
			response="Error during show profile procedure";
		}
		return response;
	}
}
