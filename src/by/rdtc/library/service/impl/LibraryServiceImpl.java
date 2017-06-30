package by.rdtc.library.service.impl;

import by.rdtc.library.bean.Book;
import by.rdtc.library.dao.BookDAO;
import by.rdtc.library.dao.DAOFactory;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.service.LibraryService;
import by.rdtc.library.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addNewBook(Book book) throws ServiceException {
		if(book==null) {throw new ServiceException("Null book");}
		DAOFactory daoObjectFactory=DAOFactory.getInstance();
		BookDAO bookDAO=daoObjectFactory.getBookDAO();
		try{
			bookDAO.addBook(book);
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	@Override
	public void addEditedBook(Book book) {
		// TODO Auto-generated method stub
		
	}

}
