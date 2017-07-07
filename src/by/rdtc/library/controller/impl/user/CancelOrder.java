package by.rdtc.library.controller.impl.user;

import java.util.Map;

import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.LibraryService;

public class CancelOrder implements Command {
	private static final String ID_ORDER = "idOrder";
	private static final int PARAMS_NUMBER = 1;

	@Override
	public String execute(Map<String, String> params) {
		int idUser;
		String idOrder = null;

		String response = null;

		if (params.size() != PARAMS_NUMBER) {
			response = "Wrong number of parameters";
			return response;
		}
		idUser=Controller.getUser().getId();
		idOrder = params.get(ID_ORDER);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LibraryService libraryService = serviceFactory.getLibraryService();
		try {
			libraryService.cancelOrder(idUser,Integer.parseInt(idOrder));
			response = "Order is closed successfully";
		} catch (ServiceException e) {
			response = "Error during ordering";
		} catch (NumberFormatException e) {
			response = "Invalid parameters";
		}
		return response;
	}

}
