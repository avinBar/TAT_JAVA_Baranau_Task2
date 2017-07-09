package by.rdtc.library.controller.impl.user;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.OrderService;

public class CancelOrder implements Command {
	private static final String ID_ORDER = "idOrder";
	private static final int PARAMS_NUMBER = 1;
	
	private static final Logger log = Logger.getLogger(CancelOrder.class);

	@Override
	public String execute(Map<String, String> params) {
		int idUser;
		int idOrder;

		String response = null;

		if (params.size() != PARAMS_NUMBER) {
			response = "Wrong number of parameters";
			return response;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		OrderService orderService = serviceFactory.getOrderService();
		try {
			idUser=Controller.getUser().getId();
			idOrder =Integer.parseInt(params.get(ID_ORDER));
			orderService.cancelOrder(idUser,idOrder);
			response = "Order is closed successfully";
		} catch (ServiceException e) {
			log.error(e);
			response = "Error during cancel order procedure";
		} catch (NumberFormatException e) {
			log.error(e);
			response = "Invalid parameters";
		}
		return response;
	}

}
