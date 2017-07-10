package by.rdtc.library.controller.impl.admin;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.BookService;

public class DeleteBook implements Command {
	private static final String ID_BOOK = "idBook";
	private static final int PARAMS_NUMBER = 1;
	
	private static final Logger log = Logger.getLogger(DeleteBook.class);

	@Override
	public String execute(Map<String, String> params) {
		int idBook;

		String response = null;

		if (params.size() != PARAMS_NUMBER) {
			response = "Wrong number of parameters";
			return response;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		try {
			idBook = Integer.parseInt(params.get(ID_BOOK));
			bookService.deleteBook(idBook);
			response = "Book is deleted";
		} catch (ServiceException e) {
			log.error(e);
			response = "Error during delete book procedure";
		} catch (NumberFormatException e) {
			log.error(e);
			response = "Invalid parameters";
		}
		return response;
	}

}
