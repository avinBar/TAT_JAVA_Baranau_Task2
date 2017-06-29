package by.rdtc.library.dao;

import by.rdtc.library.bean.Book;

public interface BookDAO {
	void addBook(Book book);
	void deleteBook(int idBook);
	void delete(Book book);
	void updateMovie();
}
