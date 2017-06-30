package by.rdtc.library.service;

import by.rdtc.library.bean.User;
import by.rdtc.library.service.exception.ServiceException;

public interface UserService {
	void signIn(String login,String password) throws ServiceException ;
	void signOut(String login);
	void registration(User user) throws ServiceException;
}
