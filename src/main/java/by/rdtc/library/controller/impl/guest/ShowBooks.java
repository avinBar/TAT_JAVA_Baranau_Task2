package by.rdtc.library.controller.impl.guest;



import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import by.rdtc.library.bean.Book;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.util.ResponseConstructor;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.BookService;

public class ShowBooks implements Command {
	private static final Logger log = Logger.getLogger(ShowBooks.class);
	
	@Override
	public String execute(Map<String,String> params) {
		String response=null;
		
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		BookService bookService=serviceFactory.getBookService();
		List<Book>books;
		try {
			books=bookService.showAllBooks();
			response=ResponseConstructor.printBookList(books);
		} catch (ServiceException e) {
			log.error(e);
			response="Error during show books procedure";
		}
		return response;
	}
}
