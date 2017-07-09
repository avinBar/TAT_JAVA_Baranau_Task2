package by.rdtc.library.controller.impl.admin;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.bean.Order;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.util.ResponseConstructor;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.OrderService;

public class ViewUsersOrders implements Command {
	private static final Logger log = Logger.getLogger(ViewUsersOrders.class);
	
	@Override
	public String execute(Map<String,String> params) {
		String response=null;
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		OrderService orderService=serviceFactory.getOrderService();
		List<Order>orders;
		try {
			orders=orderService.getUsersOrders();
			response=ResponseConstructor.printUsersOrders(orders);
		} catch (ServiceException e) {
			log.error(e);
			response="Error during view users orders procedure";
		}
		return response;
	}
}
