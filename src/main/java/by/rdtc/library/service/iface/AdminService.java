package by.rdtc.library.service.iface;

import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.service.exception.ServiceException;

public interface AdminService {
	void banUser(String login) throws ServiceException;
	void unbanUser(String login) throws ServiceException;
	void giveAdminRole(String login) throws ServiceException;
	List<User> getAllUsers() throws ServiceException;
	void removeAdmin(String login)throws ServiceException;
}
