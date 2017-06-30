package by.rdtc.library.service.impl;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.UserDAO;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.service.UserService;
import by.rdtc.library.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public void signIn(String login, String password) throws ServiceException  {
		if(login == null || login.isEmpty()){
			throw new ServiceException("Incorrect login");
		}
		DAOFactory daoObjectFactory=DAOFactory.getInstance();
		UserDAO userDAO=daoObjectFactory.getUserDAO();
		try {
			userDAO.signIn(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void signOut(String login) {
		// TODO Auto-generated method stub
		
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
