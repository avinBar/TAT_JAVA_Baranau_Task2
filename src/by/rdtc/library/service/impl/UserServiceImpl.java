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
		if (!Validator.validate(login, password)) {
			throw new ServiceException("Received null parameter");
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
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public User signOut() {
		return null;
	}

	@Override
	public void register(String login, String password, String name, String surname) throws ServiceException {
		if (!Validator.validate(login, password, name, surname)) {
			throw new ServiceException("Received null parameter");
		}
		else if (!Validator.validateLogin(login) || !Validator.validateName(name) || !Validator.validateName(surname)
				|| !Validator.validatePassword(password)) {
			throw new ServiceException("Invalid parameters");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		User user = new User(login, password, name, surname);
		try {
			userDAO.register(user);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public void editProfile(User user) throws ServiceException {
		if (null==user||!Validator.validate(user.getName(), user.getSurname())) {
			throw new ServiceException("Received null parameter");
		}
		else if (!Validator.validateName(user.getName()) || !Validator.validateName(user.getSurname())) {
			throw new ServiceException("Invalid parameters");
		}
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		try {
			userDAO.editProfile(user);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public User getUserByID(int idUser) throws ServiceException {
		if (!Validator.validate(idUser)) {
			throw new ServiceException("Received null parameter");
		}
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		User user;
		try {
			user=userDAO.getUserById(idUser);
			if(null==user){
				throw new ServiceException("No user matching your query");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		return user;
	}
}
