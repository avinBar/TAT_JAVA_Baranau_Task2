package by.rdtc.library.controller.impl.user;

import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.bean.Book;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.util.ResponseConstructor;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.BookService;

public class ViewBook implements Command {
	private static final String ID_BOOK = "idBook";
	private static final int PARAMS_NUMBER = 1;
	
	private static final Logger log = Logger.getLogger(ViewBook.class);

	@Override
	public String execute(Map<String, String> params) {
		int idBook;
		String response = null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		Book book;
		try {
			idBook = Integer.parseInt(params.get(ID_BOOK));
			book = bookService.getBookByID(idBook);
			response = ResponseConstructor.printBook(book);
		} catch (ServiceException e) {
			log.error(e);
			response = "Error during view book procedure";
		}
		return response;
	}
}
