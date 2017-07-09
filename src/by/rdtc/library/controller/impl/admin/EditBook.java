package by.rdtc.library.controller.impl.admin;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.bean.Book;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.BookService;

public class EditBook implements Command {
	private static final String ID_BOOK = "idBook";
	private static final String TITLE = "title";
	private static final String AUTHOR = "author";
	private static final int PARAMS_NUMBER = 3;
	
	private static final Logger log = Logger.getLogger(EditBook.class);

	@Override
	public String execute(Map<String, String> params) {
		int idBook;
		String title = null;
		String author = null;

		String response = null;

		if (params.size() != PARAMS_NUMBER) {
			response = "Wrong number of parameters";
			return response;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		Book book;
		try {
			idBook = Integer.parseInt(params.get(ID_BOOK));
			title = params.get(TITLE);
			author = params.get(AUTHOR);
			book = new Book(idBook, title, author);
			bookService.editBook(book);
			response = "Book is edited";
		} catch (ServiceException e) {
			log.error(e);
			response = "Error during edit book procedure";
		} catch (NumberFormatException e) {
			log.error(e);
			response = "Invalid parameters";
		}
		return response;
	}
}
