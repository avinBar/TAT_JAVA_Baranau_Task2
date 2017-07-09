package by.rdtc.library.service.impl;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.bean.Order;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.BookDAO;
import by.rdtc.library.dao.iface.OrderDAO;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.OrderService;
import by.rdtc.library.service.util.Validator;

public class OrderServiceImpl implements OrderService {
	private static final String ON_SHELF="on_shelf";

	@Override
	public void confirmReturn(int idOrder) throws ServiceException {
		if (!Validator.validate(idOrder)) {
			throw new ServiceException("Received null parameter");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoFactory.getOrderDAO();
		try {
			orderDAO.confirmReturn(idOrder);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void deliveryOrder(int idOrder) throws ServiceException {
		if (!Validator.validate(idOrder)) {
			throw new ServiceException("Received null parameter");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoFactory.getOrderDAO();
		try {
			orderDAO.deliveryOrder(idOrder);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void orderBook(int idUser, int idBook) throws ServiceException {
		if (!Validator.validate(idUser, idBook)) {
			throw new ServiceException("Received null parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoObjectFactory.getOrderDAO();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		Book book;
		try {
			book=bookDAO.getBookById(idBook);
			if(!book.getStatus().equals(ON_SHELF)){
				throw new ServiceException("Book is not available");
			}
			orderDAO.addOrder(idUser, idBook);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void cancelOrder(int idUser, int idOrder) throws ServiceException {
		if (!Validator.validate(idUser, idOrder)) {
			throw new ServiceException("Received null parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoObjectFactory.getOrderDAO();
		try {
			orderDAO.cancelOrder(idUser, idOrder);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Order> getOrders(int idUser) throws ServiceException {
		if (!Validator.validate(idUser)) {
			throw new ServiceException("Received null parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoObjectFactory.getOrderDAO();
		List<Order> orders;
		try {
			orders = orderDAO.getOrders(idUser);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return orders;
	}

	@Override
	public List<Order> getUsersOrders() throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoObjectFactory.getOrderDAO();
		List<Order> orders;
		try {
			orders = orderDAO.getUsersOrders();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return orders;
	}
}
