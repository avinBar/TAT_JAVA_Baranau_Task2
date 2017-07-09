package by.rdtc.library.service.iface;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.service.exception.ServiceException;

public interface BookService {
	void addBook(Book book) throws ServiceException;
	List<Book> showAllBooks() throws ServiceException;
	void deleteBook(int idBook) throws ServiceException;
	void editBook(Book book) throws ServiceException;
	Book getBookByID(int idBook) throws ServiceException;
}
