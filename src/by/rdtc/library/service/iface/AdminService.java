package by.rdtc.library.service.iface;

import by.rdtc.library.service.exception.ServiceException;

public interface AdminService {
	void banUser(String login) throws ServiceException;
	void unbanUser(String login) throws ServiceException;
	void giveAdminRole(String login) throws ServiceException;
	void confirmReturn(String orderId) throws ServiceException;
	void deliveryOrder(String orderId) throws ServiceException;
}
