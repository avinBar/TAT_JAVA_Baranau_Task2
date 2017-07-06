package by.rdtc.library.service.iface;

import by.rdtc.library.bean.User;
import by.rdtc.library.service.exception.ServiceException;

public interface UserService {
	User signIn(String login,String password) throws ServiceException ;
	User signOut();
	void registration(User user) throws ServiceException;
}
