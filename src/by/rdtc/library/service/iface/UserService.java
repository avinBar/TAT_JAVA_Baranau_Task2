package by.rdtc.library.service.iface;

import by.rdtc.library.bean.User;
import by.rdtc.library.service.exception.ServiceException;

public interface UserService {
	User signIn(String login,String password) throws ServiceException ;
	User signOut();
	void register(String login, String password, String name, String surname) throws ServiceException;
	User editProfile(String name, String surname) throws ServiceException;
}
