package by.rdtc.library.controller.impl.admin;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.LibraryService;

public class DeleteBook implements Command {
	private final String paramDelimeter="&";
	
	@Override
	public String execute(String request) {
		String idBook=null;
		String response=null;
		String[] param=request.split(paramDelimeter);
		idBook=param[1];
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		LibraryService libraryService=serviceFactory.getLibraryService();
		try {
			libraryService.deleteBook(Integer.parseInt(idBook));
			response="The book was deleted";
		} catch (ServiceException e) {
			response="Error during adding book procedure";
		}
		
		return response;
	}

}
