package by.rdtc.library.controller.impl.user;

import java.util.Map;

import by.rdtc.library.bean.User;
import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;

public class ShowProfile implements Command {

	@Override
	public String execute(Map<String, String> params) {
		User user=null;
		String response=null;
		
		user=Controller.getUser();
		response=user.toString();
		return response;
	}

}
