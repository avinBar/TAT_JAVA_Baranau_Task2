package by.rdtc.library.service.iface;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.service.exception.ServiceException;

public interface LibraryService {
	void addBook(Book book) throws ServiceException;
	void addEditedBook(Book book);
	List<Book> showAllBooks() throws ServiceException;
	void deleteBook(int idBook) throws ServiceException;
	void orderBook(int idUser, int idBook) throws ServiceException;
}
