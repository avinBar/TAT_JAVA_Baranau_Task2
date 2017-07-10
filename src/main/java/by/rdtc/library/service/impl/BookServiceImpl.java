package by.rdtc.library.service.impl;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.BookDAO;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.BookService;
import by.rdtc.library.service.util.Validator;

public class BookServiceImpl implements BookService {

	@Override
	public void addBook(Book book) throws ServiceException {
		if (!Validator.validateBook(book)) {
			throw new ServiceException("Received invalid book data");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			bookDAO.addBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void editBook(Book book) throws ServiceException {
		if (!Validator.validateBook(book)) {
			throw new ServiceException("Received invalid book data");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			bookDAO.updateBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Book> showAllBooks() throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		List<Book> books;
		try {
			books = bookDAO.showAllBooks();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return books;
	}

	@Override
	public void deleteBook(int idBook) throws ServiceException {
		if (!Validator.validate(idBook)) {
			throw new ServiceException("Received null parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			bookDAO.deleteBook(idBook);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Book getBookByID(int idBook) throws ServiceException {
		if (!Validator.validate(idBook)) {
			throw new ServiceException("Received null parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		Book book;
		try {
			book = bookDAO.getBookById(idBook);
			if(null==book){
				throw new ServiceException("No book matching your query");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return book;
	}
}
