package by.rdtc.library.service;

import by.rdtc.library.bean.Book;
import by.rdtc.library.service.exception.ServiceException;

public interface LibraryService {
	void addNewBook(Book book) throws ServiceException;
	void addEditedBook(Book book);
}
