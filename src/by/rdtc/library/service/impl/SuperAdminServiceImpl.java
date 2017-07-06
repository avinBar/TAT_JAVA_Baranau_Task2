package by.rdtc.library.service.impl;

import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.UserDAO;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.SuperAdminService;

public class SuperAdminServiceImpl implements SuperAdminService {

	@Override
	public void takeAdminRole(String login) throws ServiceException {
		DAOFactory daoFactory=DAOFactory.getInstance();
		UserDAO userDAO=daoFactory.getUserDAO();
		try {
			userDAO.takeAdminRole(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
