package by.rdtc.library.service.impl;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.UserDAO;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User signIn(String login, String password) throws ServiceException  {
		if(login == null || login.isEmpty()){
			throw new ServiceException("Incorrect login");
		}
		DAOFactory daoObjectFactory=DAOFactory.getInstance();
		UserDAO userDAO=daoObjectFactory.getUserDAO();
		User user;
		try {
			user=userDAO.signIn(login, password);
			return user;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public User signOut() {
		User user=null;
		return user;
	}

	@Override
	public void registration(User user) throws ServiceException {
		if(user==null){throw new ServiceException ("null");}
		DAOFactory daoObjectFactory=DAOFactory.getInstance();
		UserDAO userDAO=daoObjectFactory.getUserDAO();
		try {
			userDAO.registration(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

}
