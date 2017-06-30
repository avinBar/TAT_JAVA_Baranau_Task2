package by.rdtc.library.dao;

import by.rdtc.library.bean.Book;
import by.rdtc.library.dao.exception.DAOException;

public interface BookDAO {
	void addBook(Book book) throws DAOException;
	void deleteBook(int idBook);
	void delete(Book book);
	void updateMovie();
}
