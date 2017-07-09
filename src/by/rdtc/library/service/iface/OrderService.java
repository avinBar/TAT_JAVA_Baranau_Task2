package by.rdtc.library.service.iface;

import java.util.List;

import by.rdtc.library.bean.Order;
import by.rdtc.library.service.exception.ServiceException;

public interface OrderService {
	void confirmReturn(int idOrder) throws ServiceException;
	void deliveryOrder(int idOrder) throws ServiceException;
	void orderBook(int idUser, int idBook) throws ServiceException;
	void cancelOrder(int idUser,int idOrder) throws ServiceException;
	List<Order> getOrders(int idUser) throws ServiceException;
	List<Order> getUsersOrders() throws ServiceException;
}
