package by.rdtc.library.controller.impl.user;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.bean.Order;
import by.rdtc.library.controller.Controller;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.util.ResponseConstructor;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.OrderService;

public class ViewOrders implements Command {
	private static final Logger log = Logger.getLogger(ViewOrders.class);
	
	@Override
	public String execute(Map<String,String> params) {
		int idUser;
		String response=null;
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		OrderService orderService=serviceFactory.getOrderService();
		List<Order>orders;
		try {
			idUser=Controller.getUser().getId();
			orders=orderService.getOrders(idUser);
			response=ResponseConstructor.printOrderList(orders);
		} catch (ServiceException e) {
			log.error(e);
			response="Error during view order procedure";
		}
		return response;
	}
}
