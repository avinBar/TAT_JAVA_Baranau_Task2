package by.rdtc.library.service.impl;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.UserDAO;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.UserService;
import by.rdtc.library.service.util.Validator;

public class UserServiceImpl implements UserService {
	private static final String BANNED = "banned";

	@Override
	public User signIn(String login, String password) throws ServiceException {
		if (!Validator.validateLogin(login) || !Validator.validatePassword(password)) {
			throw new ServiceException("Invalid credentials");
		}
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		User user;
		try {
			user = userDAO.signIn(login, password);
			if (user == null) {
				throw new ServiceException("Wrong credentials");
			} else if (user.getType().equals(BANNED)) {
				throw new ServiceException("Profile is temporarily unavailable");
			}
			return user;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public User signOut() {
		User user = null;
		return user;
	}

	@Override
	public void register(String login, String password, String name, String surname) throws ServiceException {
		if (!Validator.validateLogin(login) ||
                !Validator.validateName(name) ||
                !Validator.validateName(surname)||
                !Validator.validatePassword(password)) {
            throw new ServiceException("Invalid parameters");
        }
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		User user=new User(login,password,name,surname);
		try {
			userDAO.register(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public User editProfile(String name, String surname) throws ServiceException {
		if (!Validator.validateName(name) ||
                !Validator.validateName(surname)){
            throw new ServiceException("Invalid parameters");
        }
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		User user=new User();
		try {
			userDAO.register(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return user;
}}
