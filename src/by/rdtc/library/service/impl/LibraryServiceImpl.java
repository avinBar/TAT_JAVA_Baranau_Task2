package by.rdtc.library.service.impl;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.BookDAO;
import by.rdtc.library.dao.iface.OrderDAO;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.LibraryService;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addBook(Book book) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			bookDAO.addBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addEditedBook(Book book) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Book> showAllBooks() throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		List<Book> books;
		try {
			books = bookDAO.showAllBooks();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return books;
	}

	@Override
	public void orderBook(int idUser, int idBook) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		OrderDAO orderDAO = daoObjectFactory.getOrderDAO();
		try {
			orderDAO.addOrder(idUser, idBook);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteBook(int idBook) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			bookDAO.deleteBook(idBook);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void cancelOrder(int idUser,int idOrder) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		OrderDAO bookDAO = daoObjectFactory.getOrderDAO();
		try {
			bookDAO.cancelOrder(idUser,idOrder);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
