package by.rdtc.library.service.impl;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.UserDAO;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.SuperAdminService;
import by.rdtc.library.service.util.Validator;

public class SuperAdminServiceImpl implements SuperAdminService {
	private static final String ADMIN = "admin";

	@Override
	public void removeAdmin(String login) throws ServiceException {
		if (!Validator.validateLogin(login)) {
			throw new ServiceException("Invalid parameters");
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			User user = userDAO.getUserByLogin(login);
			if (!user.getType().equals(ADMIN)) {
				throw new ServiceException();
			}
			userDAO.removeAdmin(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
