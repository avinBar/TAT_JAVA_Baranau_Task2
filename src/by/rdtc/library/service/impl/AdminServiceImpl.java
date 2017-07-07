package by.rdtc.library.service.impl;

import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.OrderDAO;
import by.rdtc.library.dao.iface.UserDAO;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.AdminService;

public class AdminServiceImpl implements AdminService {
	private static final String USER = "user";
	private static final String BANNED = "banned";

	@Override
	public void banUser(String login) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			User user = userDAO.getUserByLogin(login);
			if (!user.getType().equals(USER)) {
				throw new ServiceException();
			}
			userDAO.banUser(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void unbanUser(String login) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			User user = userDAO.getUserByLogin(login);
			if (!user.getType().equals(BANNED)) {
				throw new ServiceException();
			}
			userDAO.unbanUser(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void giveAdminRole(String login) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			User user = userDAO.getUserByLogin(login);
			if (user.getType().equals(USER)) {
				throw new ServiceException();
			}
			userDAO.giveAdminRole(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void confirmReturn(int idOrder) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoFactory.getOrderDAO();
		try {
			orderDAO.confirmReturn(idOrder);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void deliveryOrder(int idOrder) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoFactory.getOrderDAO();
		try {
			orderDAO.deliveryOrder(idOrder);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> getAllUsers() throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		List<User> users;
		try {
			users = userDAO.getAllUser();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return users;
	}

}
