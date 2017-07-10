package by.rdtc.library.dao.iface;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.dao.exception.DAOException;

public interface BookDAO {
	void addBook(Book book) throws DAOException;
	void updateBook(Book book) throws DAOException;
	void deleteBook(int idBook) throws DAOException;
	List<Book> showAllBooks() throws DAOException;
	Book getBookById(int idBook) throws DAOException;
	
}
