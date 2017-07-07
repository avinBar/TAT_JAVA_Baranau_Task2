package by.rdtc.library.controller.impl.user;


import java.util.Map;

import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.LibraryService;

public class OrderBook implements Command {
	private static final String ID_BOOK="idBook";
	private static final int PARAMS_NUMBER=1;
	
	@Override
	public String execute(Map<String,String> params) {
		int idUser;
		String idBook;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		idUser=Controller.getUser().getId();
		idBook=params.get(ID_BOOK);
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		LibraryService libraryService=serviceFactory.getLibraryService();
		try {
			libraryService.orderBook(idUser,Integer.parseInt(idBook));
			response="The book is ordered";
		} catch (ServiceException e) {
			response="Error during ordering";
		}catch (NumberFormatException e) {
			response = "Invalid parameters";
		}
		return response;
	}
}
