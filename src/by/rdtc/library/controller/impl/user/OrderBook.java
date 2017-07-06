package by.rdtc.library.controller.impl.user;


import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.LibraryService;

public class OrderBook implements Command {

	@Override
	public String execute(String request) {
		String response=null;
		int idUser;
		int idBook;
		String[] param=request.split(" ");
		idUser=Controller.getUser().getId();
		idBook=Integer.parseInt(param[1]);
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		LibraryService libraryService=serviceFactory.getLibraryService();
		try {
			libraryService.orderBook(idUser,idBook);
			response="The book was ordered";
		} catch (ServiceException e) {
			response="Error during ordering";
		}
		return response;
	}

}
