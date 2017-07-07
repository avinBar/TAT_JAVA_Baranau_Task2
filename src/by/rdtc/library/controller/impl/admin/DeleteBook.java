package by.rdtc.library.controller.impl.admin;

import java.util.Map;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.LibraryService;

public class DeleteBook implements Command {
	private static final String ID_BOOK="idBook";
	private static final int PARAMS_NUMBER=1;
	
	@Override
	public String execute(Map<String,String> params) {
		String idBook=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		idBook=params.get(ID_BOOK);
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		LibraryService libraryService=serviceFactory.getLibraryService();
		try {
			libraryService.deleteBook(Integer.parseInt(idBook));
			response="Book is deleted";
		} catch (ServiceException e) {
			response="Error during delete book procedure";
		} catch (NumberFormatException e){
			response="Invalid parameters";
		}
		
		return response;
	}

}
