package by.rdtc.library.service.impl;

import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.UserDAO;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;
import by.rdtc.library.service.util.Validator;

public class AdminServiceImpl implements AdminService {

	@Override
	public void banUser(String login) throws ServiceException {
		if (!Validator.validate(login)) {
			throw new ServiceException("Received null parameter");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			userDAO.banUser(login);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}

	}

	@Override
	public void unbanUser(String login) throws ServiceException {
		if (!Validator.validate(login)) {
			throw new ServiceException("Received null parameter");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			userDAO.unbanUser(login);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}

	}

	@Override
	public void giveAdminRole(String login) throws ServiceException {
		if (!Validator.validate(login)) {
			throw new ServiceException("Received null parameter");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			userDAO.giveAdminRole(login);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public List<User> getAllUsers() throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		List<User> users;
		try {
			users = userDAO.getAllUsers();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		return users;
	}

	@Override
	public void removeAdmin(String login) throws ServiceException {
		if (!Validator.validate(login)) {
			throw new ServiceException("Received null parameter");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			userDAO.removeAdmin(login);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

}
